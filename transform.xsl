<?xml version="1.0" encoding="utf-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="2.0">
    <xsl:template match="/">
        <Cards>
            <xsl:for-each select="/CardDefs/Entity">
                <xsl:variable name="collectible">
                    <xsl:choose>
                        <xsl:when test="Tag[@enumID='321']/@value=1">
                            <xsl:text>true</xsl:text>
                        </xsl:when>
                        <xsl:otherwise>
                            <xsl:text>false</xsl:text>
                        </xsl:otherwise>
                    </xsl:choose>
                </xsl:variable>
                <xsl:variable name="set">
                    <xsl:if test="Tag[@enumID = '183']/@value=2"><xsl:text>CORE</xsl:text></xsl:if>
                    <xsl:if test="Tag[@enumID = '183']/@value=3"><xsl:text>EXPERT</xsl:text></xsl:if>
                    <xsl:if test="Tag[@enumID = '183']/@value=4"><xsl:text>REWARD</xsl:text></xsl:if>
                    <xsl:if test="Tag[@enumID = '183']/@value=5"><xsl:text>QUEST</xsl:text></xsl:if>
                    <xsl:if test="Tag[@enumID = '183']/@value=7"><xsl:text>NONE</xsl:text></xsl:if>
                    <xsl:if test="Tag[@enumID = '183']/@value=8"><xsl:text>DEBUG</xsl:text></xsl:if>
                    <xsl:if test="Tag[@enumID = '183']/@value=11"><xsl:text>PROMO</xsl:text></xsl:if>
                    <xsl:if test="Tag[@enumID = '183']/@value=12"><xsl:text>NAXX</xsl:text></xsl:if>
                    <xsl:if test="Tag[@enumID = '183']/@value=13"><xsl:text>GVG</xsl:text></xsl:if>
                    <xsl:if test="Tag[@enumID = '183']/@value=14"><xsl:text>BRM</xsl:text></xsl:if>
                    <xsl:if test="Tag[@enumID = '183']/@value=15"><xsl:text>TGT</xsl:text></xsl:if>
                    <xsl:if test="Tag[@enumID = '183']/@value=16"><xsl:text>CREDITS</xsl:text></xsl:if>
                    <xsl:if test="Tag[@enumID = '183']/@value=17"><xsl:text>NEWHERO</xsl:text></xsl:if>
                    <xsl:if test="Tag[@enumID = '183']/@value=18"><xsl:text>BRAWL</xsl:text></xsl:if>
                    <xsl:if test="Tag[@enumID = '183']/@value=20"><xsl:text>LOE</xsl:text></xsl:if>
                    <xsl:if test="Tag[@enumID = '183']/@value=21"><xsl:text>OG</xsl:text></xsl:if>
                    <xsl:if test="Tag[@enumID = '183']/@value=23"><xsl:text>KARA</xsl:text></xsl:if>
                    <xsl:if test="Tag[@enumID = '183']/@value=24"><xsl:text>NONE</xsl:text></xsl:if>
                </xsl:variable>
                <xsl:variable name="rarity">
                    <xsl:choose>
                        <xsl:when test="Tag[@enumID = '203']/@value!=''">
                            <xsl:if test="Tag[@enumID = '203']/@value=1"><xsl:text>COMMON</xsl:text></xsl:if>
                            <xsl:if test="Tag[@enumID = '203']/@value=2"><xsl:text>FREE</xsl:text></xsl:if>
                            <xsl:if test="Tag[@enumID = '203']/@value=3"><xsl:text>RARE</xsl:text></xsl:if>
                            <xsl:if test="Tag[@enumID = '203']/@value=4"><xsl:text>EPIC</xsl:text></xsl:if>
                            <xsl:if test="Tag[@enumID = '203']/@value=5"><xsl:text>LEGENDARY</xsl:text></xsl:if>
                        </xsl:when>
                        <xsl:otherwise>
                            <xsl:text>FREE</xsl:text>
                        </xsl:otherwise>
                    </xsl:choose>
                </xsl:variable>
                <xsl:variable name="type">
                    <xsl:if test="Tag[@enumID = '202']/@value=3"><xsl:text>HERO</xsl:text></xsl:if>
                    <xsl:if test="Tag[@enumID = '202']/@value=4"><xsl:text>MINION</xsl:text></xsl:if>
                    <xsl:if test="Tag[@enumID = '202']/@value=5"><xsl:text>SPELL</xsl:text></xsl:if>
                    <xsl:if test="Tag[@enumID = '202']/@value=6"><xsl:text>ENCHANTMENT</xsl:text></xsl:if>
                    <xsl:if test="Tag[@enumID = '202']/@value=7"><xsl:text>WEAPON</xsl:text></xsl:if>
                    <xsl:if test="Tag[@enumID = '202']/@value=10"><xsl:text>HEROPOWER</xsl:text></xsl:if>
                </xsl:variable>
                <xsl:variable name="race">
                    <xsl:if test="Tag[@enumID = '200']/@value=14"><xsl:text>MURLOCK</xsl:text></xsl:if>
                    <xsl:if test="Tag[@enumID = '200']/@value=15"><xsl:text>DEMON</xsl:text></xsl:if>
                    <xsl:if test="Tag[@enumID = '200']/@value=17"><xsl:text>MECHANICAL</xsl:text></xsl:if>
                    <xsl:if test="Tag[@enumID = '200']/@value=20"><xsl:text>PET</xsl:text></xsl:if>
                    <xsl:if test="Tag[@enumID = '200']/@value=21"><xsl:text>TOTEM</xsl:text></xsl:if>
                    <xsl:if test="Tag[@enumID = '200']/@value=23"><xsl:text>PIRATE</xsl:text></xsl:if>
                    <xsl:if test="Tag[@enumID = '200']/@value=24"><xsl:text>DRAGON</xsl:text></xsl:if>
                </xsl:variable>
                <xsl:variable name="class">
                    <xsl:choose>
                        <xsl:when test="Tag[@enumID = '199']/@value!=''">
                            <xsl:if test="Tag[@enumID = '199']/@value=0"><xsl:text>DEV</xsl:text></xsl:if>
                            <xsl:if test="Tag[@enumID = '199']/@value=1"><xsl:text>DEATHKNIGHT</xsl:text></xsl:if>
                            <xsl:if test="Tag[@enumID = '199']/@value=2"><xsl:text>DRUID</xsl:text></xsl:if>
                            <xsl:if test="Tag[@enumID = '199']/@value=3"><xsl:text>HUNTER</xsl:text></xsl:if>
                            <xsl:if test="Tag[@enumID = '199']/@value=4"><xsl:text>MAGE</xsl:text></xsl:if>
                            <xsl:if test="Tag[@enumID = '199']/@value=5"><xsl:text>PALADIN</xsl:text></xsl:if>
                            <xsl:if test="Tag[@enumID = '199']/@value=6"><xsl:text>PRIEST</xsl:text></xsl:if>
                            <xsl:if test="Tag[@enumID = '199']/@value=7"><xsl:text>ROGUE</xsl:text></xsl:if>
                            <xsl:if test="Tag[@enumID = '199']/@value=8"><xsl:text>SHAMAN</xsl:text></xsl:if>
                            <xsl:if test="Tag[@enumID = '199']/@value=9"><xsl:text>WARLOCK</xsl:text></xsl:if>
                            <xsl:if test="Tag[@enumID = '199']/@value=10"><xsl:text>WARRIOR</xsl:text></xsl:if>
                            <xsl:if test="Tag[@enumID = '199']/@value=11"><xsl:text>DREAM</xsl:text></xsl:if>
                            <xsl:if test="Tag[@enumID = '199']/@value=12"><xsl:text>NEUTRAL</xsl:text></xsl:if>
                        </xsl:when>
                        <xsl:otherwise>
                            <xsl:text>NEUTRAL</xsl:text>
                        </xsl:otherwise>
                    </xsl:choose>
                </xsl:variable>
                <!-- DEFINE VARIABLES -->
                <xsl:variable name="name" select="Tag[@enumID = '185']"/>
                <xsl:variable name="cost" select="Tag[@enumID = '48']/@value"/>
                <xsl:variable name="attack" select="Tag[@enumID = '47']/@value"/>
                <xsl:variable name="health" select="Tag[@enumID = '45']/@value"/>
                <xsl:variable name="durability" select="Tag[@enumID = '187']/@value"/>
                <!-- ONLY FOR COLLECTIBLE -->
                <xsl:variable name="description" select="Tag[@enumID = '184']"/>
                <xsl:variable name="flavor" select="Tag[@enumID = '351']"/>
                <xsl:variable name="gold" select="Tag[@enumID = '365']"/>
                <xsl:variable name="artist" select="Tag[@enumID = '342']"/>
                <!-- IF NOT BASE -->
                <xsl:variable name="common" select="Tag[@enumID = '364']"/>
                <!-- MECHANICS -->
                <xsl:variable name="TRIGGER" select="Tag[@enumID = '32']/@value"/>
                <xsl:variable name="UNIQUE" select="Tag[@enumID = '114']/@value"/>
                <xsl:variable name="WINDFURY" select="Tag[@enumID = '189']/@value or ReferencedTag[@enumID = '189']/@value"/>
                <xsl:variable name="TAUNT" select="Tag[@enumID = '190']/@value or ReferencedTag[@enumID = '190']/@value"/>
                <xsl:variable name="STEALTH" select="Tag[@enumID = '191']/@value or ReferencedTag[@enumID = '191']/@value"/>
                <xsl:variable name="SPELLPOWER" select="Tag[@enumID = '192']/@value or ReferencedTag[@enumID = '192']/@value"/>
                <xsl:variable name="DIVINE_SHIELD" select="Tag[@enumID = '194']/@value or ReferencedTag[@enumID = '194']/@value"/>
                <xsl:variable name="CHARGE" select="Tag[@enumID = '197']/@value or ReferencedTag[@enumID = '197']/@value"/>
                <xsl:variable name="SUMMONED" select="Tag[@enumID = '205']/@value or ReferencedTag[@enumID = '205']/@value"/>
                <xsl:variable name="FREEZE" select="Tag[@enumID = '208']/@value or ReferencedTag[@enumID = '208']/@value"/>
                <xsl:variable name="ENRAGED" select="Tag[@enumID = '212']/@value or ReferencedTag[@enumID = '212']/@value"/>
                <xsl:variable name="OVERLOAD" select="Tag[@enumID = '215']/@value or ReferencedTag[@enumID = '215']/@value"/>
                <xsl:variable name="DEATHRATTLE" select="Tag[@enumID = '217']/@value or ReferencedTag[@enumID = '217']/@value"/>
                <xsl:variable name="BATTLECRY" select="Tag[@enumID = '218']/@value or ReferencedTag[@enumID = '218']/@value"/>
                <xsl:variable name="SECRET" select="Tag[@enumID = '219']/@value or ReferencedTag[@enumID = '219']/@value"/>
                <xsl:variable name="COMBO" select="Tag[@enumID = '220']/@value or ReferencedTag[@enumID = '220']/@value"/>
                <xsl:variable name="CANT_BE_DAMAGE" select="Tag[@enumID = '240']/@value or ReferencedTag[@enumID = '240']/@value"/>
                <xsl:variable name="TRANSFORM" select="Tag[@enumID = '293']/@value or ReferencedTag[@enumID = '293']/@value"/>
                <xsl:variable name="ONE_TURN" select="Tag[@enumID = '338']/@value or ReferencedTag[@enumID = '318']/@value"/>
                <xsl:variable name="SPARE_PART" select="Tag[@enumID = '388']/@value or ReferencedTag[@enumID = '388']/@value"/>
                <xsl:variable name="SILENCE" select="Tag[@enumID = '339']/@value or ReferencedTag[@enumID = '339']/@value"/>
                <xsl:variable name="COUNTER" select="Tag[@enumID = '340']/@value or ReferencedTag[@enumID = '340']/@value"/>
                <xsl:variable name="SPELLDAMAGE_CANT_BE_DAMAGE" select="Tag[@enumID = '349']/@value or ReferencedTag[@enumID = '349']/@value"/>
                <xsl:variable name="ADJACENT_AURA" select="Tag[@enumID = '350']/@value or ReferencedTag[@enumID = '350']/@value"/>
                <xsl:variable name="AURA" select="Tag[@enumID = '362']/@value or ReferencedTag[@enumID = '362']/@value"/>
                <xsl:variable name="POISONOUS" select="Tag[@enumID = '363']/@value or ReferencedTag[@enumID = '363']/@value"/>
                <xsl:variable name="AI_AUTOPLAY" select="Tag[@enumID = '367']/@value or ReferencedTag[@enumID = '367']/@value"/>
                <xsl:variable name="SPELLDAMEGE_BONUS" select="Tag[@enumID = '370']/@value or ReferencedTag[@enumID = '370']/@value"/>
                <xsl:variable name="TOPDECK" select="Tag[@enumID = '377']/@value or ReferencedTag[@enumID = '377']/@value"/>
                <xsl:variable name="FORGETFUL" select="Tag[@enumID = '389']/@value or ReferencedTag[@enumID = '389']/@value"/>
                <xsl:variable name="HEROPOWER_DAMAGE" select="Tag[@enumID = '396']/@value or ReferencedTag[@enumID = '396']/@value"/>
                <xsl:variable name="INSPIRE" select="Tag[@enumID = '403']/@value or ReferencedTag[@enumID = '403']/@value"/>
                <xsl:variable name="SPELLDAMEGE_DOUBLE_BONUS" select="Tag[@enumID = '404']/@value or ReferencedTag[@enumID = '404']/@value"/>
                <xsl:variable name="TREASURE" select="Tag[@enumID = '415']/@value or ReferencedTag[@enumID = '415']/@value"/>
                <xsl:variable name="RITUAL" select="Tag[@enumID = '424']/@value or ReferencedTag[@enumID = '424']/@value"/>
                <xsl:variable name="CHOOSE_ONE" select="Tag[@enumID = '443']/@value or ReferencedTag[@enumID = '443']/@value"/>
                <!--<xsl:variable name="SHIFTING" select="Tag[@enumID = '438']/@value"/>-->
                <xsl:variable name="AUTOATTACK" select="Tag[@enumID = '457']/@value or ReferencedTag[@enumID = '457']/@value"/>
                <!-- END MECHANICS -->
                <xsl:if test="$set!='DEBUG' and $set!='NONE'">
                    <Card id="{@CardID}" collectible="{$collectible}" type="{$type}">
                        <Name><xsl:value-of select="$name"/></Name>
                        <xsl:if test="$type!='ENCHANTMENT'">
                            <Set><xsl:value-of select="$set"/></Set>
                            <Rarity><xsl:value-of select="$rarity"/></Rarity>
                            <Class><xsl:value-of select="$class"/></Class>
                        </xsl:if>
                        <xsl:if test="$race!=''"><Race><xsl:value-of select="$race"/></Race></xsl:if>
                        <xsl:if test="$cost!=''"><Cost><xsl:value-of select="$cost"/></Cost></xsl:if>
                        <xsl:if test="$attack!=''"><Attack><xsl:value-of select="$attack"/></Attack></xsl:if>
                        <xsl:if test="$health!=''"><Health><xsl:value-of select="$health"/></Health></xsl:if>
                        <xsl:if test="$durability!=''"><Durability><xsl:value-of select="$durability"/></Durability></xsl:if>
                        <xsl:if test="$description!=''"><Description><xsl:value-of select="$description"/></Description></xsl:if>
                        <xsl:if test="$collectible='true'">
                            <flavor><xsl:value-of select="$flavor"/></flavor>
                            <xsl:if test="$common!=''"><Common><xsl:value-of select="$common"/></Common></xsl:if>
                            <xsl:if test="$gold!=''"><Gold><xsl:value-of select="$gold"/></Gold></xsl:if>
                            <Artist><xsl:value-of select="$artist"/></Artist>
                        </xsl:if>
                        <xsl:if test="$TRIGGER or $WINDFURY or $UNIQUE or $TAUNT or $STEALTH or $SPELLPOWER or $DIVINE_SHIELD or $CHARGE or $SUMMONED or $FREEZE or $ENRAGED or $OVERLOAD or $DEATHRATTLE or $BATTLECRY or $SECRET or $COMBO or $CANT_BE_DAMAGE or $TRANSFORM or $ONE_TURN or $SPARE_PART or $SILENCE or $SPELLDAMAGE_CANT_BE_DAMAGE or $ADJACENT_AURA or $AURA or $POISONOUS or $SPELLDAMEGE_BONUS or $TOPDECK or $FORGETFUL or $HEROPOWER_DAMAGE or $INSPIRE or $SPELLDAMEGE_DOUBLE_BONUS or $TREASURE or $RITUAL or $CHOOSE_ONE or $AUTOATTACK or @CardID='OG_123' or $COUNTER or $AI_AUTOPLAY">
                            <Mechanics>
                                <xsl:if test="@CardID='OG_123'"><Mechanic value="SHIFTING"/></xsl:if>
                                <xsl:if test="$TRIGGER"><Mechanic value="TRIGGER"/></xsl:if>
                                <xsl:if test="$WINDFURY"><Mechanic value="WINDFURY"/></xsl:if>
                                <xsl:if test="$UNIQUE"><Mechanic value="UNIQUE"/></xsl:if>
                                <xsl:if test="$TAUNT"><Mechanic value="TAUNT"/></xsl:if>
                                <xsl:if test="$STEALTH"><Mechanic value="STEALTH"/></xsl:if>
                                <xsl:if test="$SPELLPOWER"><Mechanic value="SPELLPOWER"/></xsl:if>
                                <xsl:if test="$DIVINE_SHIELD"><Mechanic value="DIVINE_SHIELD"/></xsl:if>
                                <xsl:if test="$CHARGE"><Mechanic value="CHARGE"/></xsl:if>
                                <xsl:if test="$SUMMONED"><Mechanic value="SUMMONED"/></xsl:if>
                                <xsl:if test="$FREEZE"><Mechanic value="FREEZE"/></xsl:if>
                                <xsl:if test="$ENRAGED"><Mechanic value="ENRAGED"/></xsl:if>
                                <xsl:if test="$OVERLOAD"><Mechanic value="OVERLOAD"/></xsl:if>
                                <xsl:if test="$DEATHRATTLE"><Mechanic value="DEATHRATTLE"/></xsl:if>
                                <xsl:if test="$BATTLECRY"><Mechanic value="BATTLECRY"/></xsl:if>
                                <xsl:if test="$SECRET"><Mechanic value="SECRET"/></xsl:if>
                                <xsl:if test="$COMBO"><Mechanic value="COMBO"/></xsl:if>
                                <xsl:if test="$CANT_BE_DAMAGE"><Mechanic value="CANT_BE_DAMAGE"/></xsl:if>
                                <xsl:if test="$TRANSFORM"><Mechanic value="TRANSFORM"/></xsl:if>
                                <xsl:if test="$ONE_TURN"><Mechanic value="ONE_TURN"/></xsl:if>
                                <xsl:if test="$SPARE_PART"><Mechanic value="SPARE_PART"/></xsl:if>
                                <xsl:if test="$SILENCE"><Mechanic value="SILENCE"/></xsl:if>
                                <xsl:if test="$SPELLDAMAGE_CANT_BE_DAMAGE"><Mechanic value="SPELLDAMAGE_CANT_BE_DAMAGE"/></xsl:if>
                                <xsl:if test="$ADJACENT_AURA"><Mechanic value="ADJACENT_AURA"/></xsl:if>
                                <xsl:if test="$AURA"><Mechanic value="AURA"/></xsl:if>
                                <xsl:if test="$POISONOUS"><Mechanic value="POISONOUS"/></xsl:if>
                                <xsl:if test="$SPELLDAMEGE_BONUS"><Mechanic value="SPELLDAMEGE_BONUS"/></xsl:if>
                                <xsl:if test="$TOPDECK"><Mechanic value="TOPDECK"/></xsl:if>
                                <xsl:if test="$FORGETFUL"><Mechanic value="FORGETFUL"/></xsl:if>
                                <xsl:if test="$HEROPOWER_DAMAGE"><Mechanic value="HEROPOWER_DAMAGE"/></xsl:if>
                                <xsl:if test="$INSPIRE"><Mechanic value="CANT_BE_DAMAGE"/></xsl:if>
                                <xsl:if test="$SPELLDAMEGE_DOUBLE_BONUS"><Mechanic value="SPELLDAMEGE_DOUBLE_BONUS"/></xsl:if>
                                <xsl:if test="$TREASURE"><Mechanic value="TREASURE"/></xsl:if>
                                <xsl:if test="$RITUAL"><Mechanic value="RITUAL"/></xsl:if>
                                <xsl:if test="$CHOOSE_ONE"><Mechanic value="CHOOSE_ONE"/></xsl:if>
                                <!--<xsl:if test="$SHIFTING"><Mechanic value="SHIFTING"/></xsl:if>-->
                                <xsl:if test="$AUTOATTACK"><Mechanic value="AUTOATTACK"/></xsl:if>
                                <xsl:if test="$COUNTER"><Mechanic value="COUNTER"/></xsl:if>
                                <xsl:if test="$AI_AUTOPLAY"><Mechanic value="AI_AUTOPLAY"/></xsl:if>
                            </Mechanics>
                        </xsl:if>
                        <xsl:if test="EntourageCard/@cardID!=''">
                            <EntourageCards>
                                <xsl:for-each select="EntourageCard">
                                    <EntougareCard id="{@cardID}"/>
                                </xsl:for-each>
                            </EntourageCards>
                        </xsl:if>
                    </Card>
                </xsl:if>
            </xsl:for-each>
        </Cards>
    </xsl:template>
</xsl:stylesheet>

