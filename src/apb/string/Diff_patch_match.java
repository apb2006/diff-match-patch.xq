package apb.string;

import java.util.LinkedList;

import name.fraser.neil.plaintext.*;
import name.fraser.neil.plaintext.Diff_match_patch.Diff;

import org.basex.query.iter.ValueBuilder;
import org.basex.query.value.Value;
import org.basex.query.value.node.FElem;

public class Diff_patch_match {
	 public static Value diff(String text1,String text2){
		 Diff_match_patch d=new Diff_match_patch();
		 LinkedList<Diff> dl=d.diff_main(text1, text2);
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

