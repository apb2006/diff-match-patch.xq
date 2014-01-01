import module namespace diff = "java:name.fraser.neil.plaintext.Diff_match_patch";
let $a:=diff:diff_main("aa",'àèìòù\"')
return diff:diff_prettyHtml($a)