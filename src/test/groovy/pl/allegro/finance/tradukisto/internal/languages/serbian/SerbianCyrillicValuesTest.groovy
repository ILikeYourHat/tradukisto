package pl.allegro.finance.tradukisto.internal.languages.serbian

import spock.lang.Specification
import spock.lang.Unroll

import static pl.allegro.finance.tradukisto.internal.Container.serbianCyrillicContainer

class SerbianCyrillicValuesTest extends Specification {

    static converter = serbianCyrillicContainer().getNumbersConverter()

    @Unroll
    def "should convert #value to '#words' in Serbian Cyrillic"() {
        expect:
        converter.asWords(value) == words

        where:
        value                     | words
        0                         | "нула"
        1                         | "један"
        2                         | "два"
        3                         | "три"
        4                         | "четири"
        5                         | "пет"
        6                         | "шест"
        7                         | "седам"
        8                         | "осам"
        9                         | "девет"

        11                        | "једанаест"
        12                        | "дванаест"
        13                        | "тринаест"
        14                        | "четрнаест"
        15                        | "петнаест"
        16                        | "шеснаест"
        17                        | "седамнаест"
        18                        | "осамнаест"
        19                        | "деветнаест"

        10                        | "десет"
        20                        | "двадесет"
        30                        | "тридесет"
        40                        | "четрдесет"
        50                        | "педесет"
        60                        | "шездесет"
        70                        | "седамдесет"
        80                        | "осамдесет"
        90                        | "деведесет"

        21                        | "двадесет један"
        37                        | "тридесет седам"
        43                        | "четрдесет три"
        58                        | "педесет осам"
        69                        | "шездесет девет"
        76                        | "седамдесет шест"
        82                        | "осамдесет два"
        95                        | "деведесет пет"

        100                       | "сто"
        200                       | "двеста"
        300                       | "триста"
        400                       | "четиристо"
        500                       | "петсто"
        600                       | "шестсто"
        700                       | "седамсто"
        800                       | "осамсто"
        900                       | "деветсто"

        101                       | "сто један"
        111                       | "сто једанаест"
        272                       | "двеста седамдесет два"
        387                       | "триста осамдесет седам"
        421                       | "четиристо двадесет један"
        448                       | "четиристо четрдесет осам"
        569                       | "петсто шездесет девет"
        625                       | "шестсто двадесет пет"
        782                       | "седамсто осамдесет два"
        895                       | "осамсто деведесет пет"
        999                       | "деветсто деведесет девет"

        1_000                     | "једна хиљада"
        2_000                     | "две хиљаде"
        3_000                     | "три хиљаде"
        4_000                     | "четири хиљаде"
        5_000                     | "пет хиљада"
        11_000                    | "једанаест хиљада"
        12_000                    | "дванаест хиљада"
        13_000                    | "тринаест хиљада"
        14_000                    | "четрнаест хиљада"
        15_000                    | "петнаест хиљада"
        21_000                    | "двадесет једна хиљада"

        7_634                     | "седам хиљада шестсто тридесет четири"
        24_190                    | "двадесет четири хиљаде сто деведесет"
        99_999                    | "деведесет девет хиљада деветсто деведесет девет"

        111_000                   | "сто једанаест хиљада"
        112_000                   | "сто дванаест хиљада"
        113_000                   | "сто тринаест хиљада"
        115_000                   | "сто петнаест хиљада"
        700_000                   | "седамсто хиљада"
        653_000                   | "шестсто педесет три хиљаде"

        123_454                   | "сто двадесет три хиљаде четиристо педесет четири"
        999_999                   | "деветсто деведесет девет хиљада деветсто деведесет девет"

        1_000_000                 | "један милион"
        2_000_000                 | "два милиона"
        5_000_000                 | "пет милиона"
        11_437_219                | "једанаест милиона четиристо тридесет седам хиљада двеста деветнаест"
        21_437_219                | "двадесет један милион четиристо тридесет седам хиљада двеста деветнаест"
        22_437_219                | "двадесет два милиона четиристо тридесет седам хиљада двеста деветнаест"
        23_437_219                | "двадесет три милиона четиристо тридесет седам хиљада двеста деветнаест"
        100_000_000               | "сто милиона"
        121_451_789               | "сто двадесет један милион четиристо педесет једна хиљада седамсто осамдесет девет"
        123_456_789               | "сто двадесет три милиона четиристо педесет шест хиљада седамсто осамдесет девет"

        1_000_000_000             | "једна милијарда"
        2_141_123_731             | "две милијарде сто четрдесет један милион сто двадесет три хиљаде седамсто тридесет један"
        Integer.MAX_VALUE         | "две милијарде сто четрдесет седам милиона четиристо осамдесет три хиљаде шестсто четрдесет седам"
    }
}
