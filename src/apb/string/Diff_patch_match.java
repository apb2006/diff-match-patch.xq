package apb.string;

import java.util.LinkedList;

import name.fraser.neil.plaintext.*;
import name.fraser.neil.plaintext.Diff_match_patch.Diff;

import org.basex.query.iter.ValueBuilder;
import org.basex.query.value.Value;
import org.basex.query.value.node.FElem;

public class Diff_patch_match {
	 private Diff_match_patch d=new Diff_match_patch();
	 private enum Diff_style {
		    semantic, merge,efficiency;
		}
	 public  Value diff(String text1,String text2){		
		 LinkedList<Diff> dl=d.diff_main(text1, text2);
		 return toXDM(dl);
		}
	 public  Value diff(String text1,String text2,String style){		
		 LinkedList<Diff> dl=d.diff_main(text1, text2);
		 Diff_style s = Diff_style.valueOf(style); // surround with try/catch

		 switch(s) {
		     case semantic:
		    	 d.diff_cleanupSemantic(dl);
		         break;
		     case efficiency:
		         d.diff_cleanupEfficiency(dl);
		         break;
		     // etc...
		    default:
		 }
		 
		 return toXDM(dl);
		}
	 /*
	  * linked list of diff to xml node sequence
	  */
	 public static Value toXDM( LinkedList<Diff> dl){
		 ValueBuilder vb = new ValueBuilder();
			for (Diff aDiff : dl) {
				String node=aDiff.operation.toString();
				FElem elem1 = new FElem(node);
				elem1.add(aDiff.text);
				vb.add(elem1);
			};
			return vb.value(); 
	 }
	}

