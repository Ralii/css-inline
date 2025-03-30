(defproject org.clojars.ralii/css-inline "0.0.1"
  :description "Use inline css with css-files"
  :url "https://github.com/Ralii/css-inline"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies [[org.clojure/clojure "1.11.1"]]
  :main ^:skip-aot css-inline.core
  :target-path "target/%s"
  :repositories [["releases" {:url "https://repo.clojars.org"
                              :sign-releases false}]]
  :profiles {:uberjar {:aot :all
                       :jvm-opts ["-Dclojure.compiler.direct-linking=true"]}})
