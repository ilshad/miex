(defproject miex "0.1.0-SNAPSHOT"
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [org.clojure/clojurescript "0.0-2280"]
                 [org.clojure/core.async "0.1.267.0-0d7780-alpha"]
                 [om "0.7.0"]]
  :plugins [[lein-cljsbuild "1.0.4-SNAPSHOT"]]
  :source-paths ["src"]
  :cljsbuild
  {:builds
   {:dev
    {:source-paths ["src"]
     :compiler {:output-to "app.js"
                :output-dir "out"
                :optimizations :none
                :source-map true}}
    :prod
    {:source-paths ["src"]
     :compiler {:externs ["react/externs/react.js"]
                :preamble ["react/react.min.js"]
                :pretty-print false
                :output-to "app.min.js"
                :optimizations :advanced}}}})
