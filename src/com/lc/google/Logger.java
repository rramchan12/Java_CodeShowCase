package com.lc.google;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Logger Rate Limiter - NON RUNNABLE -  LEET CODE- EASY
 * We need to design an Logger System that receives a stream of Messages +Timestamps.
 * We need to print each "unique" message - at most every 10 seconds
 *
 *
 * Egs:
 * The input will be a stream of messages + Timestamp ~ Iterator
 *                Eg [[], [1,"foo"], [2,"bar"], [3,"foo"],[8,"bar"],[10,"foo"], [11,"foo"]
 *The output will be
 *                Eg [null, true, true, false, false, false,
 *
 * Assumptions :
 * - The messages are monotonically increasing
 * - The messages could have the same time stamp
 *
 */
class Logger {

    /** Initialize your data structure here. */
    public Logger() {

    }

    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
     If this method returns false, the message will not be printed.
     The timestamp is in seconds granularity. */

    private static class LogWrapper<K,V>{
        K key;
        V value;

        public LogWrapper(K key, V value){
            this.key = key;
            this.value = value;
        }
    }


    //This is to check for Timing
    private Queue<LogWrapper<Integer, String>> msgQueue = new LinkedList<>();

    //This is to check for Uniqueness
    private HashSet<String> msgSet = new HashSet();

    public boolean shouldPrintMessage(int timestamp, String message) {

        //Check for time and clean up all the old messages
        //This is O(n) Complexity
        while (msgQueue.size()>0){
            LogWrapper<Integer,String> log = msgQueue.getFirst();
            if (timestamp- log.key >10){
                //Remove the Last message
                msgQueue.removeFirst();
                //Remove from the Set as well
                msgSet.remove(log.value);

            }
            else
                break;
        }

        //Check if the message is present, if not add it to the list
        if (!msgSet.contains(message)){
            LogWrapper<Integer,String> newEntry = new LogWrapper<Integer,String>(timestamp,String);
            msgQueue.addLast(newEntry);
            msgSet.add(message);
            return true;
        } else
            return false;




    }
}





/*

ALTERNATIVE :
The above solution has got O(N) complexity
We can also solve the above problem with O(1) Complexity by using a single HashMap
Check if the message is duplicate - If its duplicate then we just update the timestamp, if the timestamp >10 and return true
Else return Fals
Advt : O(1) complexity
Disadvt : We do not clean up the data set proactively so it can grow needlessly
 */

//class Logger {
//    private HashMap<String, Integer> msgDict;
//
//    /** Initialize your data structure here. */
//    public Logger() {
//        msgDict = new HashMap<String, Integer>();
//    }
//
//    /**
//     * Returns true if the message should be printed in the given timestamp, otherwise returns false.
//     */
//    public boolean shouldPrintMessage(int timestamp, String message) {
//
//        if (!this.msgDict.containsKey(message)) {
//            this.msgDict.put(message, timestamp);
//            return true;
//        }
//
//        Integer oldTimestamp = this.msgDict.get(message);
//        if (timestamp - oldTimestamp >= 10) {
//            this.msgDict.put(message, timestamp);
//            return true;
//        } else
//            return false;
//    }
//}