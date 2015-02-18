package edu.stanford.smi.protegex.widget.identifier;

import java.util.Collection;

import edu.stanford.smi.protege.model.*;
import edu.stanford.smi.protege.util.CollectionUtilities;
import edu.stanford.smi.protege.widget.TextFieldWidget;
import java.util.UUID;

/**
 * @author  Hemed Ali
 */

public class UBBIdentifierWidget extends TextFieldWidget {
        
	public static boolean isSuitable(Cls cls, Slot slot, Facet facet) {
    	boolean isSuitable;
    	//if ((cls == null) || (slot == null)) {
      	//	isSuitable = false;
      	//} else {
      		//boolean isAnyType = cls.getTemplateSlotValueType(slot) == ValueType.ANY;
      		boolean isMultiple = cls.getTemplateSlotAllowsMultipleValues(slot);
      		isSuitable = !isMultiple;
    	//}
		return isSuitable;
	}
        
            public void setValues(final Collection values) {
              String uniqueId = (String)CollectionUtilities.getFirstItem(values);
              Instance ins = getInstance();
             
              if (uniqueId == null){
               String s2 = ins.getName().replaceAll("([A-Z][a-z]+)_[0-9]+$","instance/person/").toLowerCase();
               
                //generate unique Id
                uniqueId = UUID.randomUUID().toString();
                setText(uniqueId);
                //getTextField().setEnabled(false);
                setInstanceValues();
                
                System.out.println("++++++++++++++++++++++\n" + s2 + uniqueId);
                System.out.println("Direct Type" + ins.getDirectType());
                System.out.print("Frame name: " + ins.getFrameID().getName());
                //ins.rename(s2 + uniqueId);
               
              }
           else 
             super.setValues(values);
        }

       /** @Override
	public void setValues(final Collection values) {
		String userName = (String) CollectionUtilities.getFirstItem(values);
        if (userName == null) {
            userName = SystemUtilities.getUserName();
      		setText(userName);
      		setInstanceValues();
        } else {
            super.setValues(values);
    	}
  	}**/
}
