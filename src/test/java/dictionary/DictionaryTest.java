package dictionary;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class DictionaryTest
{
    private final Dictionary dictionary = new Dictionary();

    @Test
        void isWord_True()
        {
            // given

            // when

            // then
            assertTrue(dictionary.isWord("happy"));
        }

        @Test
        void isWord_False()
        {
            // given

            // when

            // then
            assertFalse(dictionary.isWord("hapy"));
        }

        @Test
        void isWord_Fragment()
        {
            // given

            // when

            // then
            assertFalse(dictionary.isWord("happ"));
        }

        @Test
        void isWord_NoDef()
        {
            // given

            // when

            // then
            assertTrue(dictionary.isWord("ZOOGEOGRAPHICAL"));
        }

        @Test
        void getDef_HasDef()
        {
            // given

            // when
            String definition = dictionary.getDefinition("AAH");

            // then
            assertEquals("to exclaim in amazement, joy, or surprise [v -ED, -ING, -S]", definition);
        }

        @Test
        void getDef_NoDef()
        {
            // given

            // when
            String definition = dictionary.getDefinition("WRONGHEADEDNESS");

            // then
            assertEquals("", definition);
        }

        @Test
        void getDef_BadWord()
        {
            // given
            Dictionary dictionary = new Dictionary();

            // when
            String definition = dictionary.getDefinition("hapy");

            // then
            assertNull(definition);
        }

        @Test
        void getDef_FragWord()
        {
            // given

            // when
            String definition = dictionary.getDefinition("hapy");

            // then
            assertNull(definition);
        }

}