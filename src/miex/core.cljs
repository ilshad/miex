(ns miex.core
  (:require-macros [cljs.core.async.macros :refer [go-loop alt!]])
  (:require [cljs.core.async :refer [put! alts! chan <! >!]]
            [om.core :as om :include-macros true]
            [om.dom :as dom :include-macros true]
            [miex.mock :refer [app-state]]
            [miex.util :refer [div ul li span action icon]]))

(enable-console-print!)

(defn main-view [app _]
  (reify
    om/IRender
    (render [_]
      (div "row"
        "Main view"))))

(defn root-view [app _]
  (reify
    om/IRender
    (render [_]
      (div "container"
        (case (:focus app)
          :main (om/build main-view app)
          "unrecognized focus name")))))

(om/root root-view app-state
  {:target (. js/document (getElementById "app"))})
