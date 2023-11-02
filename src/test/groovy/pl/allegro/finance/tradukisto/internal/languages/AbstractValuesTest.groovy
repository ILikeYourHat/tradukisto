package pl.allegro.finance.tradukisto.internal.languages

import pl.allegro.finance.tradukisto.internal.IntegerToStringConverter
import pl.allegro.finance.tradukisto.internal.LongToStringConverter
import spock.lang.Specification
import spock.lang.Unroll

abstract class AbstractValuesTest extends Specification {
    abstract ValuesTestData testData
    abstract IntegerToStringConverter intConverter
    abstract LongToStringConverter longConverter

    private static final OBLIGATORY_INT_VALUES = [
            0, 1, 2, 3, 4, 5, 6, 7, 8, 9,
            11, 12, 13, 14, 15, 16, 17, 18, 19,
            10, 20, 30, 40, 50, 60, 70, 80, 90,
            21, 37, 43, 58, 69, 76, 82, 95,
            100, 200, 300, 400, 500, 600, 700, 800, 900,
            111, 272, 387, 448, 569, 625, 782, 895, 999,
            1_000, 2_000, 3_000, 4_000, 5_000, 7_634, 11_000,
            15_000, 21_000, 24_190, 653_000, 123_454, 700_000, 999_999,
            1_000_000, 2_000_000, 5_000_000, 23_437_219,
            100_000_000, 123_456_789, 322_089_890,
            1_000_000_000, 2_147_483_647,
    ]

    private static final OBLIGATORY_LONG_VALUES = [
            5_000_000_000,
            1_000_000_000_000,
            2_000_000_000_000,
            5_000_000_000_000,
            1_000_000_000_000_000,
            2_000_000_000_000_000,
            5_000_000_000_000_000,
            1_000_000_000_000_000_000,
            2_000_000_000_000_000_000,
            Long.MAX_VALUE
    ]

    @Unroll
    def "should convert integer #input to #output"() {
        expect:
        intConverter.asWords(input) == output

        where:
        input << getTestData().getIntegerTranslations().keySet()
        output << getTestData().getIntegerTranslations().values()
    }

    @Unroll
    def "should convert long #input to #output"() {
        expect:
        longConverter.asWords(input) == output

        where:
        input << getTestData().getLongTranslations().keySet()
        output << getTestData().getLongTranslations().values()
    }

    static class ValuesTestData {
        private final Map<Integer, String> integerTranslations
        private final Map<Long, String> longTranslations

        ValuesTestData(Map<Integer, String> integerTranslations, Map<Long, String> longTranslations) {
            this.integerTranslations = prepareIntegerInput(integerTranslations)
            this.longTranslations = prepareLongInput(longTranslations)
        }

        Map<Integer, String> getIntegerTranslations() {
            return integerTranslations
        }

        Map<Long, String> getLongTranslations() {
            return longTranslations
        }

        private static prepareIntegerInput(Map<Integer, String> intWords) {
            OBLIGATORY_INT_VALUES.stream()
                    .forEach {
                        intWords.putIfAbsent(it, "⚠️Please specify expected output")
                    }
            return intWords.sort { it.key }
        }

        private static prepareLongInput(Map<Long, String> longWords) {
            OBLIGATORY_LONG_VALUES.stream()
                    .forEach {
                        longWords.putIfAbsent(it, "⚠️Please specify expected output")
                    }
            return longWords.sort { it.key }
        }
    }
}
