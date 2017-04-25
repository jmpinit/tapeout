(ns tapeout.utilities)

(defn append [el]
  (.appendChild (.-body js/document) el))
