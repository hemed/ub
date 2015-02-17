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
        
        @Override
          public void setValues(final Collection values) {
            String uniqueId = (String)CollectionUtilities.getFirstItem(values);
            
            if (uniqueId == null){
                
               //generate unique Id 
               uniqueId = UUID.randomUUID().toString();
              
               setText(uniqueId);
               getTextField().setEnabled(false);
               setInstanceValues();
             } else {
              super.setValues(values);
            }
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
