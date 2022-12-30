/**
 * Stavy stroje
 *  {@link #S_0}
 *  {@link #S_1A}
 *  {@link #S_2A}
 *  {@link #S_3A}
 *  {@link #S_4A}
 *  {@link #S_5A}
 *  {@link #S_1B}
 *  {@link #S_2B}
 *  {@link #S_3B}
 *  {@link #S_4B}
 *  {@link #S_5B}
 *  {@link #S_6}
 *  {@link #S_7}
 */
public enum StrojStav {
    /////////////////////////////
    ////// Počáteční stav ///////
    /////////////////////////////

    /** Systém čeká na vstup */
    S_0,

    /////////////////////////////
    ////// Cyklus nádoby A //////
    /////////////////////////////

    /** Napouštění louhem A */
    S_1A,
    /** Vypouštění louhu A */
    S_2A,
    /** Napouštění vodou A */
    S_3A,
    /** Proplachování vodou A */
    S_4A,
    /** Vypouštění vody A */
    S_5A,

    /////////////////////////////
    ////// Cyklus nádoby B //////
    /////////////////////////////

    /** Napouštění louhem B */
    S_1B,
    /** Vypouštění louhu B */
    S_2B,
    /** Napouštění vodou B */
    S_3B,
    /** Proplachování vodou B */
    S_4B,
    /** Vypouštění vody B */
    S_5B,

    /////////////////////////////
    ////// Chybový cyklus ///////
    /////////////////////////////

    /** Nádrže nejsou prázdné */
    S_6,
    /** Ruční vypouštění obou nádrží */
    S_7
}
