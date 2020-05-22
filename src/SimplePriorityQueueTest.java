import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SimplePriorityQueueTest {

    SimplePriorityQueue simplePQ;
    @Test
    public void testHeapify() {
        simplePQ = new SimplePriorityQueue(new Integer[]{2 ,5 ,6, -3, 0});
        assertEquals(5, simplePQ.size());
        assertEquals(-3, simplePQ.poll());
        assertEquals(0, simplePQ.poll());
        assertEquals(3, simplePQ.size());
    }

    @Test
    public void testOfferAndResize() {
        simplePQ = new SimplePriorityQueue(new Integer[]{2});
        assertEquals(2, simplePQ.peek());
        simplePQ.offer(-1);
        assertEquals(-1, simplePQ.peek());
        assertEquals(2, simplePQ.size());
    }

    @Test
    public void testPoll() {
        simplePQ = new SimplePriorityQueue();
        simplePQ.offer(5);
        simplePQ.offer(2);
        assertEquals(2, simplePQ.poll());
        assertEquals(1, simplePQ.size());
    }

    @Test
    public void testEmptyException() {
        simplePQ = new SimplePriorityQueue();
        Exception pollException = assertThrows(IllegalArgumentException.class, () -> {
            simplePQ.poll();
        });
        Exception peekException = assertThrows(IllegalArgumentException.class, () -> {
            simplePQ.poll();
        });

        String expectedMessage = "no element in this LoopArray";
        assertTrue(pollException.getMessage().contains(expectedMessage));
        assertTrue(peekException.getMessage().contains(expectedMessage));
    }

}