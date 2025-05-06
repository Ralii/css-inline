# css-inline

Turn css files into inline-css

## installation

![Clojars Project](https://img.shields.io/clojars/v/org.clojars.ralii/css-inline.svg)

## Requirements
- Clojure
- Hiccup or any other vector based html-rendering library

## Usage

There is some magic happening that you should be aware of. To use ns-css in certain namespace, you need to make a css-file with same name. For example `table.clj` | `table.css`.
Calling `ns-css` will parse the css-file and expose class-names from the css-file. `css` contains `[:style css-string....]` so it can be used in the root component of the file.
`style-styled-table` is a classname found from the file and exposed to developer. With at least cider I am able to get autocomplete for these.

Example ns (table.clj):

``` clojure

(ns table
  (:require
   [css-inline.core :refer [ns-css]]))

(ns-css)

(defn- table-head []
  [:thead
   [:tr
    [:th "Name"]
    [:th "Business-id"]
    [:th "Industry code"]
    [:th "Date"]]])

(defn table [companies]
  [:div
   css
   [:table {:class style-styled-table
            :border "1"}
    (table-head)
    [:tbody
     (for [{:keys [name business-id industry-code registration-date]} companies]
       [:tr
        [:td name]
        [:td business-id]
        [:td main-business-line]
        [:td registration-date]])]]])
```

Example css (table.css):

``` css
 .styled-table {
    width: 100%;
    border-collapse: collapse;
    font-family: Arial, sans-serif;
}

```

Both files are in the same folder.
