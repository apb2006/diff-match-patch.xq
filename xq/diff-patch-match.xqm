xquery version "3.0" encoding "UTF-8";
(:~ 
: basex binding for Neil Fraser's diff_patch_match library'
: @author andy bunce
:)
module namespace dpm = 'apb.string.diff-patch-match';
declare default function namespace 'apb.string.diff-patch-match';


import module namespace diff = "java:name.fraser.neil.plaintext.Diff_match_patch";

declare function diff($s1 as xs:string,
                      $s2 as xs:string){
 diff:diff_main($s1,$s2)
};