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
<EQUAL>The </EQUAL>
<DELETE>te</DELETE>
<EQUAL>s</EQUAL>
<DELETE>t</DELETE>
<INSERT>imilar</INSERT>
<EQUAL> string</EQUAL>
````

````
import module namespace dmp="apb.string.Diff_patch_match";
dmp:diff("The test string","The similar string","semantic")
````
result
````
<EQUAL>The </EQUAL>
<DELETE>test</DELETE>
<INSERT>similar</INSERT>
<EQUAL> string</EQUAL>
````

# Installation @TODO
The library is packaged in the [EXpath](http://expath.org/spec/pkg) xar format with 
the  jars included. It can be installed into the BaseX repository by 
executing the command:
````
repo:install('http://apb2006.github.io/diff-patch-match/dist/diff-patch-match.zar')
````
