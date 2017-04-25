(ns tapeout.core
  (:require [clojure.browser.repl :as repl]))

(enable-console-print!)

(def THREE js/THREE)

(def camera
  (let [width (.-innerWidth js/window)
        height (.-innerHeight js/window)]
    (THREE.PerspectiveCamera. 75 (/ width height) 1 10000)))

(set! (.-z (.-position camera)) 1000)

(def renderer (THREE.WebGLRenderer.))
(def scene (THREE.Scene.))
(def geometry (THREE.CubeGeometry. 200 200 200))
(def obj (js/Object.))

(set! (.-color obj) 0xff0000)
(set! (.-wireframe obj) true)

(def material (THREE.MeshBasicMaterial. obj))
(def mesh (THREE.Mesh. geometry material))

(.add scene mesh)

(.setSize renderer (.-innerWidth js/window) (.-innerHeight js/window))
(.appendChild (.-body js/document) (.-domElement renderer))

(defn render []
  (set! (.-x (.-rotation mesh)) (+ (.-x (.-rotation mesh)) 0.01))
  (set! (.-y (.-rotation mesh)) (+ (.-y (.-rotation mesh)) 0.02))
  (.render renderer scene camera))

(defn animate []
  (.requestAnimationFrame js/window animate)
  (render))

(animate)
