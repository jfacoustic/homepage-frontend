(ns homepage.home)

(defn home []
  [:section {:class "hero is-fullheight"}
   [:div {:class "hero-body"}
    [:div {:class "container introduction"}
     [:h1 {:class "title has-text-light"} "Introduction"]
     [:p {:class "has-text-light"} (str
                                    "Hi, I'm Josh Mathews. "
                                    "I'm a musician, software developer, and advocate of the Oxford Comma. "
                                    "I'm currently a consultant for IBM in Baton Rouge, Louisiana, building high-performance enterprise applications. "
                                    "This site is currently in progress.  I'm rewriting it from the ground up with full-stack Clojure. ")]
     [:p {:class "has-text-light has-text-right side-note"} "Some friends and I took this picture!  We were sponsored by the Colorado Space Grant Consortium to launch a ballon-sat. "
      [:a {:href "http://thecrite.com/coloradomesau/ground-control-major-tom/"} "More Info"]]]]])