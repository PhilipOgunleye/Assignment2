/*
 * Copyright 2015 Len Payne <len.payne@lambtoncollege.ca>.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package cpd4414.assign2;

import cpd4414.assign2.OrderQueue;
import cpd4414.assign2.Purchase;
import cpd4414.assign2.Order;
import java.util.Date;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author  <len.payne@lambtoncollege.ca>
 */
public class OrderQueueTest {
    
    public OrderQueueTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testWhenCustomerExistsAndPurchasesExistThenTimeReceivedIsNow() throws Exception {
        OrderQueue orderQueue = new OrderQueue();
        Order order = new Order("CUST00001", "ABC Construction");
        order.addPurchase(new Purchase("PROD0004", 450));
        order.addPurchase(new Purchase("PROD0006", 250));
        orderQueue.add(order);
        
        long expResult = new Date().getTime();
        long result = order.getTimeReceived().getTime();
        assertTrue(Math.abs(result - expResult) < 1000);
    }
    
     @Test
      public void testWhenNeitherCustomerIdNorCustomerNameExistsThrowAnException(){
        OrderQueue orderQueue = new OrderQueue();
        boolean result = false;
        Order order = new Order("","");
        try{
        orderQueue.add(order);
         }
        catch(Exception e){
          result=true;
        }
        assertTrue(result);
      }
    @Test
      public void testWhenNoListOfPurchasesThrowException(){
      Boolean result=false;
      OrderQueue orderQueue = new OrderQueue();
        Order order = new Order("","");
       
        try{
        orderQueue.add(order);
        
        }
        catch(Exception e){
            result = true;
                    
        }assertTrue(result);
                 
             
          
      }

 @Test
    public void testWhenNoOrdersInSystemReturnOrderWithEarliestTimeReceivedWithNoTimeProcessed() throws Exception {
        OrderQueue orderQueue = new OrderQueue();
        Order order = new Order("CUST00001", "ABC Construction");
        order.addPurchase(new Purchase("PROD0004", 450));
        order.addPurchase(new Purchase("PROD0006", 250));
        orderQueue.add(order);
        Order outcomeA=orderQueue.requestOrder();
        Order outcomeB= orderQueue.orderQueue.peek();
        assertEquals(outcomeA,outcomeB);
        
        

    }
    @Test
    public void testWhenNoOrdersInTheSystemReturnNull(){
     OrderQueue orderQueue = new OrderQueue();
     Order outcomeB = orderQueue.requestOrder();
     assertEquals(outcomeB, null);
        
        
    }
    
    @Test
    public void testWhenOrderHasATimeReceivedAndPurchasesInStockThenTimeProcessedIsNow() throws Exception {
        
        OrderQueue orderQueue = new OrderQueue();
        Order order = new Order("CUST00001", "ABC Construction");
        order.addPurchase(new Purchase("PROD0004", 450));
        order.addPurchase(new Purchase("PROD0006", 250));
        orderQueue.add(order);
        
        long expResult = new Date().getTime();
        long result = order.getTimeProcessed().getTime();
        assertTrue(Math.abs(result - expResult) < 1000);
    
    
    
}
    
    @Test
      public void testWhenOrderDoesNotHaveTimeReceivedThrowAnException(){
        OrderQueue orderQueue = new OrderQueue();
        boolean result = false;
        Order order = new Order("","");
        try{
        orderQueue.timeReceived(order);
         }
        catch(Exception e){
          result=true;
        }
        assertTrue(result);
      }
    
      @Test
    public void testWhenOrderHasATimeReceivedAndPurchasesInStockThenTimeFulfilledIsNow() throws Exception {
        
        OrderQueue orderQueue = new OrderQueue();
        Order order = new Order("CUST00001", "ABC Construction");
        order.addPurchase(new Purchase("PROD0004", 450));
        order.addPurchase(new Purchase("PROD0006", 250));
        orderQueue.add(order);
        
        long expResult = new Date().getTime();
        long result = order.getTimeFulfilled().getTime();
        assertTrue(Math.abs(result - expResult) < 1000);
    
}
    
    @Test
      public void testWhenOrderDoesNotHaveTimeProcessedThrowAnException(){
        OrderQueue orderQueue = new OrderQueue();
        boolean result = false;
        Order order = new Order("","");
        try{
        orderQueue.timeProcessed(order);
         }
        catch(Exception e){
          result=true;
        }
        assertTrue(result);
      }
      
       @Test
//      public void testWhenOrderDoesNotHaveTimeReceivedThrowAnException(){
//        OrderQueue orderQueue = new OrderQueue();
//        boolean result = false;
//        Order order = new Order("","");
//        try{
//        orderQueue.add(timeReceivd);
//         }
//        catch(Exception e){
//          result=true;
//        }
//        assertTrue(result);
//      }
      

    public void testWhenNoOrdersInTheSystemReturnEmptyString(){
      OrderQueue orderQueue = new OrderQueue();
 String outcomeA = orderQueue.report();
   assertEquals("",outcomeA);
      
      
}
}
      
      
      
      
      


