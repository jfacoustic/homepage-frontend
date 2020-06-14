(ns homepage.navbar)
(require '[goog.dom.classlist :as gc])

(defn toggle-menu []
  (let [node (js/document.getElementById "navbar-menu")]
    (gc/toggle node "is-active")))

(defn navbar-menu []
  [:div {:id "navbar-menu" :class "navbar-menu"}
   [:div {:class "navbar-start"}
    [:a {:class "navbar-item" :href "http://www.joshfeltonmathews.com"} "Music"]
    [:a {:class "navbar-item" :href "http://www.github.com/jfacoustic"} "Github"]
    [:a {:class "navbar-item" :href "http://resume.joshfeltonmathews.com"} "Resume"]]])

(defn burger []
  [:a {:role "button"
       :class "navbar-burger burger"
       :aria-label "menu"
       :aria-expanded "false"
       :data-target "navbar-menu"
       :onClick toggle-menu}
   [:span {:aria-hidden "true"}]
   [:span {:aria-hidden "true"}]
   [:span {:aria-hidden "true"}]])

(defn navbar-brand []
  [:div {:class "navbar-brand"}
   [:a {:class "navbar-item navbar-title" :href "/"}
    "Josh Felton Mathews"]
   [burger]])

(defn navbar []
  [:nav {:class "navbar" :role "navigation" :aria-label "main navigation"}
   [navbar-brand]
   [navbar-menu]])