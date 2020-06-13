(ns homepage.core
  (:require
   [reagent.core :as r]
   [reagent.dom :as d]
   [secretary.core :as secretary  :include-macros true]
   [accountant.core :as accountant]
   [goog.events :as events]
   [goog.history.EventType :as HistoryEventType])
   (:import goog.History))

;; -------------------------
;; Views
(defn homepage []
  [:p "Joshua Mathews is a software developer, musician, adventurer, and advocate of the Oxford Comma.  He's currently a full-stack engineer at IBM."])
(defn music []
  [:p "MUSIC"])

(def current-page (r/atom homepage))

(secretary/defroute "/" [] 
  (reset! current-page homepage))
(secretary/defroute "/music" []
  (reset! current-page music))

  ;; -------------------------
  ;; History
  ;; must be called after routes have been defined

  (defn hook-browser-navigation! []
    (doto (History.)
          (events/listen
           HistoryEventType/NAVIGATE
           (fn [event]
             (secretary/dispatch! (.-token event))))
          (.setEnabled true)))
  
(defn nav-bar []
  [:ul
   [:li [:a {:href "/"} "Home"]]
   [:li [:a {:href "/music"} "Music"]]
   [:li [:a {:href "/resume"} "Resume"]]])


(defn content []
  [:div
   [:h1 "Josh Felton Mathews"]
   [nav-bar]
   [@current-page]])
;; -------------------------
;; Initialize app
(defn mount-root []
  (d/render [content] (.getElementById js/document "app")))

  (defn init! []
    (accountant/configure-navigation!
     {:nav-handler
      (fn [path]
        (secretary/dispatch! path))
      :path-exists?
      (fn [path]
        (secretary/locate-route path))})
    (accountant/dispatch-current!)
    (mount-root))