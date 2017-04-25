(ns tapeout.layer)

(defn setAttribute [el name value]
  (do
    (println el name value)
    (.setAttribute el name value)
    el))

(defn svgEl [name attrs]
  (let [el (.createElementNS js/document "http://www.w3.org/2000/svg" name)]
    (println attrs)
    (reduce-kv setAttribute el attrs)))

(defn createRoot []
  (svgEl "svg" {}))

(defn createTest []
  (let [root (createRoot)
        line (svgEl "line" {"stroke" "red", "x1" 0, "y1" 0, "x2" 100, "y2" 100})]
    (.appendChild root line)
    root))
