/*
 * Diff Match and Patch
 *
 * Copyright 2013 Andy Bunce.
 * https://github.com/apb2006/diff-match-patch.xq
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package apb.string;

import java.util.LinkedList;

import name.fraser.neil.plaintext.Diff_match_patch.Diff;

import org.basex.query.iter.ValueBuilder;
import org.basex.query.value.Value;
import org.basex.query.value.node.FElem;

public class Diff_match_patch {
	 private name.fraser.neil.plaintext.Diff_match_patch d=new name.fraser.neil.plaintext.Diff_match_patch();
	
	 public  Value diff(String text1,String text2){		
		 LinkedList<Diff> dl=d.diff_main(text1, text2);
		 return toXDM(dl);
		}
	 
	 public Value diff_cleanupSemantic(String text1,String text2){
		 LinkedList<Diff> dl=d.diff_main(text1, text2);
		 d.diff_cleanupSemantic(dl);
		 return toXDM(dl);
	 }
	 public Value diff_cleanupSemanticLossless(String text1,String text2){
		 LinkedList<Diff> dl=d.diff_main(text1, text2);
		 d.diff_cleanupSemanticLossless(dl);
		 return toXDM(dl);
	 }
	 public Value diff_cleanupEfficiency(String text1,String text2){
		 LinkedList<Diff> dl=d.diff_main(text1, text2);
		 d.diff_cleanupEfficiency(dl);
		 return toXDM(dl);
	 }
	
	 /*
	  * linked list of diff to xml diffs node sequence
	  */
	 public static Value toXDM( LinkedList<Diff> dl){
		 ValueBuilder vb = new ValueBuilder();
		    FElem root=new FElem("diffs");
			for (Diff aDiff : dl) {
				String node=aDiff.operation.toString().toLowerCase();
				FElem elem1 = new FElem(node);
				elem1.add(aDiff.text);
				root.add(elem1);
			};
			vb.add(root);
			return vb.value(); 
	 }
	}

