(ns css-inline.core
  (:require
   [clojure.string :as str]))

(defn extract-css-classes [css-content]
  (let [class-pattern #"(?<=\.)[a-zA-Z][a-zA-Z0-9_-]*"
        matches (re-seq class-pattern css-content)]
    (set matches)))  ;; Use a set to avoid duplicates

(defn output-def [css-class]
  `(def ~(symbol (str "style-" css-class)) ~(str css-class)))

(defmacro ns-css []
  "Macro that will expose every class in css-file as style-`class-name` prefix.
   Whole css-file will be exposed as string with symbol `css`"
  (let [path-to-file (str "src/"(str/replace *ns* "." "/") ".css")
        file (slurp path-to-file)
        css-classes (extract-css-classes file)
        css-class-defs (map output-def css-classes)]
    `(do
       ~@css-class-defs
       (def ~(symbol (str *ns* "/css")) [:style ~(str file)]))))
