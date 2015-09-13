package ninja.smirking.grep.wrapper;

import org.junit.Test;

/**
 * @author Connor Spencer Harries
 */
public class WrappedSenderTest {
    @Test
    public void testSendMessage() throws Exception {
        StandardOutputSender sender = new StandardOutputSender("testSendMessage");
        WrappedSender wrapped = new WrappedSender(sender, "*");
        wrapped.sendMessage("Hello world");
        sender.assertSent("Hello world");
    }

    @Test
    public void testSendMessageArray() throws Exception {
        StandardOutputSender sender = new StandardOutputSender("testSendMessageArray");
        WrappedSender wrapped = new WrappedSender(sender, "foo");
        String[] messages = new String[]{
                "foo",
                "bar",
                "baz",
                "I like food"
        };
        wrapped.sendMessage(messages);
        sender.assertSent(messages[0]);
        sender.assertSent(messages[3]);
    }
}