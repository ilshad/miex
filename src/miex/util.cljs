(ns miex.util
  (:require [om.dom :as dom :include-macros true]))

(defn- tag [tag class-names & contents]
  (apply tag #js {:className class-names} contents))

(def div   (partial tag dom/div))
(def ul    (partial tag dom/ul))
(def li    (partial tag dom/li))
(def span  (partial tag dom/span))

(defn icon [& class-names]
  (dom/i #js {:className (apply str
                           (interpose " "
                             (conj class-names "fa")))}))

(defn action [class-names f & contents]
  (apply dom/a #js {:href "#"
                    :className class-names
                    :onClick (fn [e] (f e) false)} contents))
