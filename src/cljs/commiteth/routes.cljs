(ns commiteth.routes
  (:require [bide.core :as bide]
            [re-frame.core :as rf]))

(defonce router
  (bide/router [["/"               :bounties]
                ["/activity"       :activity]
                ["/repos"          :repos]
                ["/dashboard"      :dashboard]
                ["/dashboard/to-confirm" :issuer-dashboard/to-confirm]
                ["/dashboard/to-merge"   :issuer-dashboard/to-merge]
                ["/settings"       :settings]
                ["/usage-metrics"  :usage-metrics]]))

(defn on-navigate
  "A function which will be called on each route change."
  [name params query]
  (println "Route change to: " name params query)
  (rf/dispatch [:set-active-page name]))

(defn setup-nav! []
  (bide/start! router {:default     :bounties
                       :on-navigate on-navigate}))

(defn nav! [route-id]
  (bide/navigate! router route-id {}))

