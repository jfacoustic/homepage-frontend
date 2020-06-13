(ns homepage.navbar)

(defn navbar []
  [:nav {:class "navbar" :role "navigation" :aria-label "main navigation"}
   [:div {:class "navbar-brand"}
    [:a {:class "navbar-item navbar-title" :href "/"}
     "Josh Felton Mathews"]
    [:a {:role "button"
         :class "navbar-burger burger"
         :aria-label "menu"
         :aria-expanded "false"
         :data-target "navbarBasicExample"}
     [:span {:aria-hidden "true"}]
     [:span {:aria-hidden "true"}]
     [:span {:aria-hidden "true"}]]]
   [:div {:id "navbarBasicExample" :class "navbar-menu"}
    [:div {:class "navbar-start"}
     [:a {:class "navbar-item" :href "http://www.joshfeltonmathews.com"} "Music"]
     [:a {:class "navbar-item" :href "http://www.github.com/jfacoustic"} "Github"]
     [:a {:class "navbar-item" :href "http://resume.joshfeltonmathews.com"} "Resume"]]]])