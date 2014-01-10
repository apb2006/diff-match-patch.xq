# apb.string.diff-patch-match
An XQuery library to compute string differences using the 
[diff patch match library](http://code.google.com/p/google-diff-match-patch/)  

* Work in progress API changes expected
* BaseX 7.7 or greater is required.

````
import module namespace dmp="apb.string.Diff_patch_match";
dmp:diff("The test string","The similar string")
````
result
````
<diffs>
  <equal>The </equal>
  <delete>te</delete>
  <equal>s</equal>
  <delete>t</delete>
  <insert>imilar</insert>
  <equal> string</equal>
</diffs>
````

````
import module namespace dmp = "java:apb.string.Diff_match_patch";
dmp:diff_cleanupSemantic("The test string","The similar string"
````
result
````
<diffs>
  <equal>The </equal>
  <delete>test</delete>
  <insert>similar</insert>
  <equal> string</equal>
</diffs>
````

# Installation @TODO
The library is packaged in the [EXpath](http://expath.org/spec/pkg) xar format with 
the  jars included. It can be installed into the BaseX repository by 
executing the command:
````
repo:install('http://apb2006.github.io/diff-patch-match/dist/diff-patch-match.zar')
````
