/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DynamicERP.frames.sales;

import java.awt.Adjustable;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;

class MyAdjustmentListener implements AdjustmentListener {
  public void adjustmentValueChanged(AdjustmentEvent evt) {
    Adjustable source = evt.getAdjustable();
    if (evt.getValueIsAdjusting()) {
      return;
    }
    int orient = source.getOrientation();
    if (orient == Adjustable.HORIZONTAL) {
      System.out.println("from horizontal scrollbar"); 
    } else {
      System.out.println("from vertical scrollbar");
    }
    int type = evt.getAdjustmentType();
    switch (type) {
    case AdjustmentEvent.UNIT_INCREMENT:
      System.out.println("Scrollbar was increased by one unit");
      break;
    case AdjustmentEvent.UNIT_DECREMENT:
      System.out.println("Scrollbar was decreased by one unit");
      break;
    case AdjustmentEvent.BLOCK_INCREMENT:
      System.out.println("Scrollbar was increased by one block");
      break;
    case AdjustmentEvent.BLOCK_DECREMENT:
      System.out.println("Scrollbar was decreased by one block");
      break;
    case AdjustmentEvent.TRACK:
      System.out.println("The knob on the scrollbar was dragged");
      break;
    }
    int value = evt.getValue();
  }
}