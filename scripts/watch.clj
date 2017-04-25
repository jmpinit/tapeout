(require '[cljs.build.api :as b])

(b/watch "src"
  {:main 'tapeout.core
   :output-to "out/tapeout.js"
   :output-dir "out"})
