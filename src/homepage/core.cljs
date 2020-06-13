(ns homepage.core
  (:require
   [homepage.navbar :refer [navbar]]
   [homepage.home :refer [home]]
   [reagent.core :as r]
   [reagent.dom :as d]
   [secretary.core :as secretary  :include-macros true]
   [accountant.core :as accountant]
   [goog.events :as events]
   [goog.history.EventType :as HistoryEventType])
   (:import goog.History))

;; -------------------------
;; Views


(def current-page (r/atom home))

(secretary/defroute "/" [] 
  (reset! current-page home))


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
  



(defn content []
  [:div
   [navbar]
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