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

import java.util.ArrayDeque;
import java.util.Date;
import java.util.Queue;

/**
 *
 * @author philip
 */
public class OrderQueue {

    Queue<Order> orderQueue = new ArrayDeque<>();

    public void add(Order order) throws Exception {
        if (order.getCustomerId().isEmpty() && order.getCustomerName().isEmpty()) {
            throw new Exception("customer name and ID does not exist");
        }
        orderQueue.add(order);
        order.setTimeReceived(new Date());
    }

    public Order requestOrder() {
        if (orderQueue.isEmpty()) {
            return null;
        }
        return orderQueue.peek();
    }

    public void timeProcessed(Order order) throws Exception {

        if (order.getTimeProcessed() == null) {
            throw new Exception("order does not have a time processed");

        }
        if (order.getTimeReceived() == null) {
            throw new Exception("order does not have a time received");
        }
    }

    public String report() {
        if (orderQueue.isEmpty()) {
            return "";
        }
        return "";

    }

    public void timeReceived(Order order) throws Exception {

        if (order.getTimeProcessed() == null) {
            throw new Exception("order does not have a time received");

        }
        if (order.getTimeReceived() == null) {
            throw new Exception("order does not have a time received");
        }
    }

    private boolean Stock(int quantity, String productId) {

        boolean StockSTK = true;
        if (quantity > Inventory.getQuantityForId(productId)) {
            StockSTK = false;
        }
        return StockSTK;

    }

    void fulfilledOrder(Order nextOrder) throws Exception {

        boolean StockSTK = true;
        if (nextOrder.getTimeReceived() != null) {
            if (nextOrder.getTimeProcessed() != null) {
                for (int i = 0; i < nextOrder.getListOfPurchases().size(); i++) {
                    StockSTK = Stock(nextOrder.getListOfPurchases().get(i).getQuantity(), nextOrder.getListOfPurchases().get(i).getProductId());
                }
                if (StockSTK) {
                    nextOrder.setTimeFulfilled(new Date());
                }
            } else {
                throw new Exception("order has a time processed and a time received and all of the purchases are in-stock in the inventory table");
            }
        } else {
            throw new Exception("when the order does not have a time received, then throw an exception");
        }
    }
}
