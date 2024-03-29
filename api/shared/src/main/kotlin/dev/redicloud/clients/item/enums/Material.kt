@file:Suppress("unused", "SpellCheckingInspection")

package dev.redicloud.clients.item.enums

enum class Material(val id: Int) : MaterialLike {
    AIR(0),
    STONE(1),
    GRANITE(2),
    POLISHED_GRANITE(3),
    DIORITE(4),
    POLISHED_DIORITE(5),
    ANDESITE(6),
    POLISHED_ANDESITE(7),
    DEEPSLATE(8),
    COBBLED_DEEPSLATE(9),
    POLISHED_DEEPSLATE(10),
    CALCITE(11),
    TUFF(12),
    DRIPSTONE_BLOCK(13),
    GRASS_BLOCK(14),
    DIRT(15),
    COARSE_DIRT(16),
    PODZOL(17),
    ROOTED_DIRT(18),
    MUD(19),
    CRIMSON_NYLIUM(20),
    WARPED_NYLIUM(21),
    COBBLESTONE(22),
    OAK_PLANKS(23),
    SPRUCE_PLANKS(24),
    BIRCH_PLANKS(25),
    JUNGLE_PLANKS(26),
    ACACIA_PLANKS(27),
    DARK_OAK_PLANKS(28),
    MANGROVE_PLANKS(29),
    CRIMSON_PLANKS(30),
    WARPED_PLANKS(31),
    OAK_SAPLING(32),
    SPRUCE_SAPLING(33),
    BIRCH_SAPLING(34),
    JUNGLE_SAPLING(35),
    ACACIA_SAPLING(36),
    DARK_OAK_SAPLING(37),
    MANGROVE_PROPAGULE(38),
    BEDROCK(39),
    SAND(40),
    RED_SAND(41),
    GRAVEL(42),
    COAL_ORE(43),
    DEEPSLATE_COAL_ORE(44),
    IRON_ORE(45),
    DEEPSLATE_IRON_ORE(46),
    COPPER_ORE(47),
    DEEPSLATE_COPPER_ORE(48),
    GOLD_ORE(49),
    DEEPSLATE_GOLD_ORE(50),
    REDSTONE_ORE(51),
    DEEPSLATE_REDSTONE_ORE(52),
    EMERALD_ORE(53),
    DEEPSLATE_EMERALD_ORE(54),
    LAPIS_ORE(55),
    DEEPSLATE_LAPIS_ORE(56),
    DIAMOND_ORE(57),
    DEEPSLATE_DIAMOND_ORE(58),
    NETHER_GOLD_ORE(59),
    NETHER_QUARTZ_ORE(60),
    ANCIENT_DEBRIS(61),
    COAL_BLOCK(62),
    RAW_IRON_BLOCK(63),
    RAW_COPPER_BLOCK(64),
    RAW_GOLD_BLOCK(65),
    AMETHYST_BLOCK(66),
    BUDDING_AMETHYST(67),
    IRON_BLOCK(68),
    COPPER_BLOCK(69),
    GOLD_BLOCK(70),
    DIAMOND_BLOCK(71),
    NETHERITE_BLOCK(72),
    EXPOSED_COPPER(73),
    WEATHERED_COPPER(74),
    OXIDIZED_COPPER(75),
    CUT_COPPER(76),
    EXPOSED_CUT_COPPER(77),
    WEATHERED_CUT_COPPER(78),
    OXIDIZED_CUT_COPPER(79),
    CUT_COPPER_STAIRS(80),
    EXPOSED_CUT_COPPER_STAIRS(81),
    WEATHERED_CUT_COPPER_STAIRS(82),
    OXIDIZED_CUT_COPPER_STAIRS(83),
    CUT_COPPER_SLAB(84),
    EXPOSED_CUT_COPPER_SLAB(85),
    WEATHERED_CUT_COPPER_SLAB(86),
    OXIDIZED_CUT_COPPER_SLAB(87),
    WAXED_COPPER_BLOCK(88),
    WAXED_EXPOSED_COPPER(89),
    WAXED_WEATHERED_COPPER(90),
    WAXED_OXIDIZED_COPPER(91),
    WAXED_CUT_COPPER(92),
    WAXED_EXPOSED_CUT_COPPER(93),
    WAXED_WEATHERED_CUT_COPPER(94),
    WAXED_OXIDIZED_CUT_COPPER(95),
    WAXED_CUT_COPPER_STAIRS(96),
    WAXED_EXPOSED_CUT_COPPER_STAIRS(97),
    WAXED_WEATHERED_CUT_COPPER_STAIRS(98),
    WAXED_OXIDIZED_CUT_COPPER_STAIRS(99),
    WAXED_CUT_COPPER_SLAB(100),
    WAXED_EXPOSED_CUT_COPPER_SLAB(101),
    WAXED_WEATHERED_CUT_COPPER_SLAB(102),
    WAXED_OXIDIZED_CUT_COPPER_SLAB(103),
    OAK_LOG(104),
    SPRUCE_LOG(105),
    BIRCH_LOG(106),
    JUNGLE_LOG(107),
    ACACIA_LOG(108),
    DARK_OAK_LOG(109),
    MANGROVE_LOG(110),
    MANGROVE_ROOTS(111),
    MUDDY_MANGROVE_ROOTS(112),
    CRIMSON_STEM(113),
    WARPED_STEM(114),
    STRIPPED_OAK_LOG(115),
    STRIPPED_SPRUCE_LOG(116),
    STRIPPED_BIRCH_LOG(117),
    STRIPPED_JUNGLE_LOG(118),
    STRIPPED_ACACIA_LOG(119),
    STRIPPED_DARK_OAK_LOG(120),
    STRIPPED_MANGROVE_LOG(121),
    STRIPPED_CRIMSON_STEM(122),
    STRIPPED_WARPED_STEM(123),
    STRIPPED_OAK_WOOD(124),
    STRIPPED_SPRUCE_WOOD(125),
    STRIPPED_BIRCH_WOOD(126),
    STRIPPED_JUNGLE_WOOD(127),
    STRIPPED_ACACIA_WOOD(128),
    STRIPPED_DARK_OAK_WOOD(129),
    STRIPPED_MANGROVE_WOOD(130),
    STRIPPED_CRIMSON_HYPHAE(131),
    STRIPPED_WARPED_HYPHAE(132),
    OAK_WOOD(133),
    SPRUCE_WOOD(134),
    BIRCH_WOOD(135),
    JUNGLE_WOOD(136),
    ACACIA_WOOD(137),
    DARK_OAK_WOOD(138),
    MANGROVE_WOOD(139),
    CRIMSON_HYPHAE(140),
    WARPED_HYPHAE(141),
    OAK_LEAVES(142),
    SPRUCE_LEAVES(143),
    BIRCH_LEAVES(144),
    JUNGLE_LEAVES(145),
    ACACIA_LEAVES(146),
    DARK_OAK_LEAVES(147),
    MANGROVE_LEAVES(148),
    AZALEA_LEAVES(149),
    FLOWERING_AZALEA_LEAVES(150),
    SPONGE(151),
    WET_SPONGE(152),
    GLASS(153),
    TINTED_GLASS(154),
    LAPIS_BLOCK(155),
    SANDSTONE(156),
    CHISELED_SANDSTONE(157),
    CUT_SANDSTONE(158),
    COBWEB(159),
    GRASS(160),
    FERN(161),
    AZALEA(162),
    FLOWERING_AZALEA(163),
    DEAD_BUSH(164),
    SEAGRASS(165),
    SEA_PICKLE(166),
    WHITE_WOOL(167),
    ORANGE_WOOL(168),
    MAGENTA_WOOL(169),
    LIGHT_BLUE_WOOL(170),
    YELLOW_WOOL(171),
    LIME_WOOL(172),
    PINK_WOOL(173),
    GRAY_WOOL(174),
    LIGHT_GRAY_WOOL(175),
    CYAN_WOOL(176),
    PURPLE_WOOL(177),
    BLUE_WOOL(178),
    BROWN_WOOL(179),
    GREEN_WOOL(180),
    RED_WOOL(181),
    BLACK_WOOL(182),
    DANDELION(183),
    POPPY(184),
    BLUE_ORCHID(185),
    ALLIUM(186),
    AZURE_BLUET(187),
    RED_TULIP(188),
    ORANGE_TULIP(189),
    WHITE_TULIP(190),
    PINK_TULIP(191),
    OXEYE_DAISY(192),
    CORNFLOWER(193),
    LILY_OF_THE_VALLEY(194),
    WITHER_ROSE(195),
    SPORE_BLOSSOM(196),
    BROWN_MUSHROOM(197),
    RED_MUSHROOM(198),
    CRIMSON_FUNGUS(199),
    WARPED_FUNGUS(200),
    CRIMSON_ROOTS(201),
    WARPED_ROOTS(202),
    NETHER_SPROUTS(203),
    WEEPING_VINES(204),
    TWISTING_VINES(205),
    SUGAR_CANE(206),
    KELP(207),
    MOSS_CARPET(208),
    MOSS_BLOCK(209),
    HANGING_ROOTS(210),
    BIG_DRIPLEAF(211),
    SMALL_DRIPLEAF(212),
    BAMBOO(213),
    OAK_SLAB(214),
    SPRUCE_SLAB(215),
    BIRCH_SLAB(216),
    JUNGLE_SLAB(217),
    ACACIA_SLAB(218),
    DARK_OAK_SLAB(219),
    MANGROVE_SLAB(220),
    CRIMSON_SLAB(221),
    WARPED_SLAB(222),
    STONE_SLAB(223),
    SMOOTH_STONE_SLAB(224),
    SANDSTONE_SLAB(225),
    CUT_SANDSTONE_SLAB(226),
    PETRIFIED_OAK_SLAB(227),
    COBBLESTONE_SLAB(228),
    BRICK_SLAB(229),
    STONE_BRICK_SLAB(230),
    MUD_BRICK_SLAB(231),
    NETHER_BRICK_SLAB(232),
    QUARTZ_SLAB(233),
    RED_SANDSTONE_SLAB(234),
    CUT_RED_SANDSTONE_SLAB(235),
    PURPUR_SLAB(236),
    PRISMARINE_SLAB(237),
    PRISMARINE_BRICK_SLAB(238),
    DARK_PRISMARINE_SLAB(239),
    SMOOTH_QUARTZ(240),
    SMOOTH_RED_SANDSTONE(241),
    SMOOTH_SANDSTONE(242),
    SMOOTH_STONE(243),
    BRICKS(244),
    BOOKSHELF(245),
    MOSSY_COBBLESTONE(246),
    OBSIDIAN(247),
    TORCH(248),
    END_ROD(249),
    CHORUS_PLANT(250),
    CHORUS_FLOWER(251),
    PURPUR_BLOCK(252),
    PURPUR_PILLAR(253),
    PURPUR_STAIRS(254),
    SPAWNER(255),
    CHEST(256),
    CRAFTING_TABLE(257),
    FARMLAND(258),
    FURNACE(259),
    LADDER(260),
    COBBLESTONE_STAIRS(261),
    SNOW(262),
    ICE(263),
    SNOW_BLOCK(264),
    CACTUS(265),
    CLAY(266),
    JUKEBOX(267),
    OAK_FENCE(268),
    SPRUCE_FENCE(269),
    BIRCH_FENCE(270),
    JUNGLE_FENCE(271),
    ACACIA_FENCE(272),
    DARK_OAK_FENCE(273),
    MANGROVE_FENCE(274),
    CRIMSON_FENCE(275),
    WARPED_FENCE(276),
    PUMPKIN(277),
    CARVED_PUMPKIN(278),
    JACK_O_LANTERN(279),
    NETHERRACK(280),
    SOUL_SAND(281),
    SOUL_SOIL(282),
    BASALT(283),
    POLISHED_BASALT(284),
    SMOOTH_BASALT(285),
    SOUL_TORCH(286),
    GLOWSTONE(287),
    INFESTED_STONE(288),
    INFESTED_COBBLESTONE(289),
    INFESTED_STONE_BRICKS(290),
    INFESTED_MOSSY_STONE_BRICKS(291),
    INFESTED_CRACKED_STONE_BRICKS(292),
    INFESTED_CHISELED_STONE_BRICKS(293),
    INFESTED_DEEPSLATE(294),
    STONE_BRICKS(295),
    MOSSY_STONE_BRICKS(296),
    CRACKED_STONE_BRICKS(297),
    CHISELED_STONE_BRICKS(298),
    PACKED_MUD(299),
    MUD_BRICKS(300),
    DEEPSLATE_BRICKS(301),
    CRACKED_DEEPSLATE_BRICKS(302),
    DEEPSLATE_TILES(303),
    CRACKED_DEEPSLATE_TILES(304),
    CHISELED_DEEPSLATE(305),
    REINFORCED_DEEPSLATE(306),
    BROWN_MUSHROOM_BLOCK(307),
    RED_MUSHROOM_BLOCK(308),
    MUSHROOM_STEM(309),
    IRON_BARS(310),
    CHAIN(311),
    GLASS_PANE(312),
    MELON(313),
    VINE(314),
    GLOW_LICHEN(315),
    BRICK_STAIRS(316),
    STONE_BRICK_STAIRS(317),
    MUD_BRICK_STAIRS(318),
    MYCELIUM(319),
    LILY_PAD(320),
    NETHER_BRICKS(321),
    CRACKED_NETHER_BRICKS(322),
    CHISELED_NETHER_BRICKS(323),
    NETHER_BRICK_FENCE(324),
    NETHER_BRICK_STAIRS(325),
    SCULK(326),
    SCULK_VEIN(327),
    SCULK_CATALYST(328),
    SCULK_SHRIEKER(329),
    ENCHANTING_TABLE(330),
    END_PORTAL_FRAME(331),
    END_STONE(332),
    END_STONE_BRICKS(333),
    DRAGON_EGG(334),
    SANDSTONE_STAIRS(335),
    ENDER_CHEST(336),
    EMERALD_BLOCK(337),
    OAK_STAIRS(338),
    SPRUCE_STAIRS(339),
    BIRCH_STAIRS(340),
    JUNGLE_STAIRS(341),
    ACACIA_STAIRS(342),
    DARK_OAK_STAIRS(343),
    MANGROVE_STAIRS(344),
    CRIMSON_STAIRS(345),
    WARPED_STAIRS(346),
    COMMAND_BLOCK(347),
    BEACON(348),
    COBBLESTONE_WALL(349),
    MOSSY_COBBLESTONE_WALL(350),
    BRICK_WALL(351),
    PRISMARINE_WALL(352),
    RED_SANDSTONE_WALL(353),
    MOSSY_STONE_BRICK_WALL(354),
    GRANITE_WALL(355),
    STONE_BRICK_WALL(356),
    MUD_BRICK_WALL(357),
    NETHER_BRICK_WALL(358),
    ANDESITE_WALL(359),
    RED_NETHER_BRICK_WALL(360),
    SANDSTONE_WALL(361),
    END_STONE_BRICK_WALL(362),
    DIORITE_WALL(363),
    BLACKSTONE_WALL(364),
    POLISHED_BLACKSTONE_WALL(365),
    POLISHED_BLACKSTONE_BRICK_WALL(366),
    COBBLED_DEEPSLATE_WALL(367),
    POLISHED_DEEPSLATE_WALL(368),
    DEEPSLATE_BRICK_WALL(369),
    DEEPSLATE_TILE_WALL(370),
    ANVIL(371),
    CHIPPED_ANVIL(372),
    DAMAGED_ANVIL(373),
    CHISELED_QUARTZ_BLOCK(374),
    QUARTZ_BLOCK(375),
    QUARTZ_BRICKS(376),
    QUARTZ_PILLAR(377),
    QUARTZ_STAIRS(378),
    WHITE_TERRACOTTA(379),
    ORANGE_TERRACOTTA(380),
    MAGENTA_TERRACOTTA(381),
    LIGHT_BLUE_TERRACOTTA(382),
    YELLOW_TERRACOTTA(383),
    LIME_TERRACOTTA(384),
    PINK_TERRACOTTA(385),
    GRAY_TERRACOTTA(386),
    LIGHT_GRAY_TERRACOTTA(387),
    CYAN_TERRACOTTA(388),
    PURPLE_TERRACOTTA(389),
    BLUE_TERRACOTTA(390),
    BROWN_TERRACOTTA(391),
    GREEN_TERRACOTTA(392),
    RED_TERRACOTTA(393),
    BLACK_TERRACOTTA(394),
    BARRIER(395),
    LIGHT(396),
    HAY_BLOCK(397),
    WHITE_CARPET(398),
    ORANGE_CARPET(399),
    MAGENTA_CARPET(400),
    LIGHT_BLUE_CARPET(401),
    YELLOW_CARPET(402),
    LIME_CARPET(403),
    PINK_CARPET(404),
    GRAY_CARPET(405),
    LIGHT_GRAY_CARPET(406),
    CYAN_CARPET(407),
    PURPLE_CARPET(408),
    BLUE_CARPET(409),
    BROWN_CARPET(410),
    GREEN_CARPET(411),
    RED_CARPET(412),
    BLACK_CARPET(413),
    TERRACOTTA(414),
    PACKED_ICE(415),
    DIRT_PATH(416),
    SUNFLOWER(417),
    LILAC(418),
    ROSE_BUSH(419),
    PEONY(420),
    TALL_GRASS(421),
    LARGE_FERN(422),
    WHITE_STAINED_GLASS(423),
    ORANGE_STAINED_GLASS(424),
    MAGENTA_STAINED_GLASS(425),
    LIGHT_BLUE_STAINED_GLASS(426),
    YELLOW_STAINED_GLASS(427),
    LIME_STAINED_GLASS(428),
    PINK_STAINED_GLASS(429),
    GRAY_STAINED_GLASS(430),
    LIGHT_GRAY_STAINED_GLASS(431),
    CYAN_STAINED_GLASS(432),
    PURPLE_STAINED_GLASS(433),
    BLUE_STAINED_GLASS(434),
    BROWN_STAINED_GLASS(435),
    GREEN_STAINED_GLASS(436),
    RED_STAINED_GLASS(437),
    BLACK_STAINED_GLASS(438),
    WHITE_STAINED_GLASS_PANE(439),
    ORANGE_STAINED_GLASS_PANE(440),
    MAGENTA_STAINED_GLASS_PANE(441),
    LIGHT_BLUE_STAINED_GLASS_PANE(442),
    YELLOW_STAINED_GLASS_PANE(443),
    LIME_STAINED_GLASS_PANE(444),
    PINK_STAINED_GLASS_PANE(445),
    GRAY_STAINED_GLASS_PANE(446),
    LIGHT_GRAY_STAINED_GLASS_PANE(447),
    CYAN_STAINED_GLASS_PANE(448),
    PURPLE_STAINED_GLASS_PANE(449),
    BLUE_STAINED_GLASS_PANE(450),
    BROWN_STAINED_GLASS_PANE(451),
    GREEN_STAINED_GLASS_PANE(452),
    RED_STAINED_GLASS_PANE(453),
    BLACK_STAINED_GLASS_PANE(454),
    PRISMARINE(455),
    PRISMARINE_BRICKS(456),
    DARK_PRISMARINE(457),
    PRISMARINE_STAIRS(458),
    PRISMARINE_BRICK_STAIRS(459),
    DARK_PRISMARINE_STAIRS(460),
    SEA_LANTERN(461),
    RED_SANDSTONE(462),
    CHISELED_RED_SANDSTONE(463),
    CUT_RED_SANDSTONE(464),
    RED_SANDSTONE_STAIRS(465),
    REPEATING_COMMAND_BLOCK(466),
    CHAIN_COMMAND_BLOCK(467),
    MAGMA_BLOCK(468),
    NETHER_WART_BLOCK(469),
    WARPED_WART_BLOCK(470),
    RED_NETHER_BRICKS(471),
    BONE_BLOCK(472),
    STRUCTURE_VOID(473),
    SHULKER_BOX(474),
    WHITE_SHULKER_BOX(475),
    ORANGE_SHULKER_BOX(476),
    MAGENTA_SHULKER_BOX(477),
    LIGHT_BLUE_SHULKER_BOX(478),
    YELLOW_SHULKER_BOX(479),
    LIME_SHULKER_BOX(480),
    PINK_SHULKER_BOX(481),
    GRAY_SHULKER_BOX(482),
    LIGHT_GRAY_SHULKER_BOX(483),
    CYAN_SHULKER_BOX(484),
    PURPLE_SHULKER_BOX(485),
    BLUE_SHULKER_BOX(486),
    BROWN_SHULKER_BOX(487),
    GREEN_SHULKER_BOX(488),
    RED_SHULKER_BOX(489),
    BLACK_SHULKER_BOX(490),
    WHITE_GLAZED_TERRACOTTA(491),
    ORANGE_GLAZED_TERRACOTTA(492),
    MAGENTA_GLAZED_TERRACOTTA(493),
    LIGHT_BLUE_GLAZED_TERRACOTTA(494),
    YELLOW_GLAZED_TERRACOTTA(495),
    LIME_GLAZED_TERRACOTTA(496),
    PINK_GLAZED_TERRACOTTA(497),
    GRAY_GLAZED_TERRACOTTA(498),
    LIGHT_GRAY_GLAZED_TERRACOTTA(499),
    CYAN_GLAZED_TERRACOTTA(500),
    PURPLE_GLAZED_TERRACOTTA(501),
    BLUE_GLAZED_TERRACOTTA(502),
    BROWN_GLAZED_TERRACOTTA(503),
    GREEN_GLAZED_TERRACOTTA(504),
    RED_GLAZED_TERRACOTTA(505),
    BLACK_GLAZED_TERRACOTTA(506),
    WHITE_CONCRETE(507),
    ORANGE_CONCRETE(508),
    MAGENTA_CONCRETE(509),
    LIGHT_BLUE_CONCRETE(510),
    YELLOW_CONCRETE(511),
    LIME_CONCRETE(512),
    PINK_CONCRETE(513),
    GRAY_CONCRETE(514),
    LIGHT_GRAY_CONCRETE(515),
    CYAN_CONCRETE(516),
    PURPLE_CONCRETE(517),
    BLUE_CONCRETE(518),
    BROWN_CONCRETE(519),
    GREEN_CONCRETE(520),
    RED_CONCRETE(521),
    BLACK_CONCRETE(522),
    WHITE_CONCRETE_POWDER(523),
    ORANGE_CONCRETE_POWDER(524),
    MAGENTA_CONCRETE_POWDER(525),
    LIGHT_BLUE_CONCRETE_POWDER(526),
    YELLOW_CONCRETE_POWDER(527),
    LIME_CONCRETE_POWDER(528),
    PINK_CONCRETE_POWDER(529),
    GRAY_CONCRETE_POWDER(530),
    LIGHT_GRAY_CONCRETE_POWDER(531),
    CYAN_CONCRETE_POWDER(532),
    PURPLE_CONCRETE_POWDER(533),
    BLUE_CONCRETE_POWDER(534),
    BROWN_CONCRETE_POWDER(535),
    GREEN_CONCRETE_POWDER(536),
    RED_CONCRETE_POWDER(537),
    BLACK_CONCRETE_POWDER(538),
    TURTLE_EGG(539),
    DEAD_TUBE_CORAL_BLOCK(540),
    DEAD_BRAIN_CORAL_BLOCK(541),
    DEAD_BUBBLE_CORAL_BLOCK(542),
    DEAD_FIRE_CORAL_BLOCK(543),
    DEAD_HORN_CORAL_BLOCK(544),
    TUBE_CORAL_BLOCK(545),
    BRAIN_CORAL_BLOCK(546),
    BUBBLE_CORAL_BLOCK(547),
    FIRE_CORAL_BLOCK(548),
    HORN_CORAL_BLOCK(549),
    TUBE_CORAL(550),
    BRAIN_CORAL(551),
    BUBBLE_CORAL(552),
    FIRE_CORAL(553),
    HORN_CORAL(554),
    DEAD_BRAIN_CORAL(555),
    DEAD_BUBBLE_CORAL(556),
    DEAD_FIRE_CORAL(557),
    DEAD_HORN_CORAL(558),
    DEAD_TUBE_CORAL(559),
    TUBE_CORAL_FAN(560),
    BRAIN_CORAL_FAN(561),
    BUBBLE_CORAL_FAN(562),
    FIRE_CORAL_FAN(563),
    HORN_CORAL_FAN(564),
    DEAD_TUBE_CORAL_FAN(565),
    DEAD_BRAIN_CORAL_FAN(566),
    DEAD_BUBBLE_CORAL_FAN(567),
    DEAD_FIRE_CORAL_FAN(568),
    DEAD_HORN_CORAL_FAN(569),
    BLUE_ICE(570),
    CONDUIT(571),
    POLISHED_GRANITE_STAIRS(572),
    SMOOTH_RED_SANDSTONE_STAIRS(573),
    MOSSY_STONE_BRICK_STAIRS(574),
    POLISHED_DIORITE_STAIRS(575),
    MOSSY_COBBLESTONE_STAIRS(576),
    END_STONE_BRICK_STAIRS(577),
    STONE_STAIRS(578),
    SMOOTH_SANDSTONE_STAIRS(579),
    SMOOTH_QUARTZ_STAIRS(580),
    GRANITE_STAIRS(581),
    ANDESITE_STAIRS(582),
    RED_NETHER_BRICK_STAIRS(583),
    POLISHED_ANDESITE_STAIRS(584),
    DIORITE_STAIRS(585),
    COBBLED_DEEPSLATE_STAIRS(586),
    POLISHED_DEEPSLATE_STAIRS(587),
    DEEPSLATE_BRICK_STAIRS(588),
    DEEPSLATE_TILE_STAIRS(589),
    POLISHED_GRANITE_SLAB(590),
    SMOOTH_RED_SANDSTONE_SLAB(591),
    MOSSY_STONE_BRICK_SLAB(592),
    POLISHED_DIORITE_SLAB(593),
    MOSSY_COBBLESTONE_SLAB(594),
    END_STONE_BRICK_SLAB(595),
    SMOOTH_SANDSTONE_SLAB(596),
    SMOOTH_QUARTZ_SLAB(597),
    GRANITE_SLAB(598),
    ANDESITE_SLAB(599),
    RED_NETHER_BRICK_SLAB(600),
    POLISHED_ANDESITE_SLAB(601),
    DIORITE_SLAB(602),
    COBBLED_DEEPSLATE_SLAB(603),
    POLISHED_DEEPSLATE_SLAB(604),
    DEEPSLATE_BRICK_SLAB(605),
    DEEPSLATE_TILE_SLAB(606),
    SCAFFOLDING(607),
    REDSTONE(608),
    REDSTONE_TORCH(609),
    REDSTONE_BLOCK(610),
    REPEATER(611),
    COMPARATOR(612),
    PISTON(613),
    STICKY_PISTON(614),
    SLIME_BLOCK(615),
    HONEY_BLOCK(616),
    OBSERVER(617),
    HOPPER(618),
    DISPENSER(619),
    DROPPER(620),
    LECTERN(621),
    TARGET(622),
    LEVER(623),
    LIGHTNING_ROD(624),
    DAYLIGHT_DETECTOR(625),
    SCULK_SENSOR(626),
    TRIPWIRE_HOOK(627),
    TRAPPED_CHEST(628),
    TNT(629),
    REDSTONE_LAMP(630),
    NOTE_BLOCK(631),
    STONE_BUTTON(632),
    POLISHED_BLACKSTONE_BUTTON(633),
    OAK_BUTTON(634),
    SPRUCE_BUTTON(635),
    BIRCH_BUTTON(636),
    JUNGLE_BUTTON(637),
    ACACIA_BUTTON(638),
    DARK_OAK_BUTTON(639),
    MANGROVE_BUTTON(640),
    CRIMSON_BUTTON(641),
    WARPED_BUTTON(642),
    STONE_PRESSURE_PLATE(643),
    POLISHED_BLACKSTONE_PRESSURE_PLATE(644),
    LIGHT_WEIGHTED_PRESSURE_PLATE(645),
    HEAVY_WEIGHTED_PRESSURE_PLATE(646),
    OAK_PRESSURE_PLATE(647),
    SPRUCE_PRESSURE_PLATE(648),
    BIRCH_PRESSURE_PLATE(649),
    JUNGLE_PRESSURE_PLATE(650),
    ACACIA_PRESSURE_PLATE(651),
    DARK_OAK_PRESSURE_PLATE(652),
    MANGROVE_PRESSURE_PLATE(653),
    CRIMSON_PRESSURE_PLATE(654),
    WARPED_PRESSURE_PLATE(655),
    IRON_DOOR(656),
    OAK_DOOR(657),
    SPRUCE_DOOR(658),
    BIRCH_DOOR(659),
    JUNGLE_DOOR(660),
    ACACIA_DOOR(661),
    DARK_OAK_DOOR(662),
    MANGROVE_DOOR(663),
    CRIMSON_DOOR(664),
    WARPED_DOOR(665),
    IRON_TRAPDOOR(666),
    OAK_TRAPDOOR(667),
    SPRUCE_TRAPDOOR(668),
    BIRCH_TRAPDOOR(669),
    JUNGLE_TRAPDOOR(670),
    ACACIA_TRAPDOOR(671),
    DARK_OAK_TRAPDOOR(672),
    MANGROVE_TRAPDOOR(673),
    CRIMSON_TRAPDOOR(674),
    WARPED_TRAPDOOR(675),
    OAK_FENCE_GATE(676),
    SPRUCE_FENCE_GATE(677),
    BIRCH_FENCE_GATE(678),
    JUNGLE_FENCE_GATE(679),
    ACACIA_FENCE_GATE(680),
    DARK_OAK_FENCE_GATE(681),
    MANGROVE_FENCE_GATE(682),
    CRIMSON_FENCE_GATE(683),
    WARPED_FENCE_GATE(684),
    POWERED_RAIL(685),
    DETECTOR_RAIL(686),
    RAIL(687),
    ACTIVATOR_RAIL(688),
    SADDLE(689),
    MINECART(690),
    CHEST_MINECART(691),
    FURNACE_MINECART(692),
    TNT_MINECART(693),
    HOPPER_MINECART(694),
    CARROT_ON_A_STICK(695),
    WARPED_FUNGUS_ON_A_STICK(696),
    ELYTRA(697),
    OAK_BOAT(698),
    OAK_CHEST_BOAT(699),
    SPRUCE_BOAT(700),
    SPRUCE_CHEST_BOAT(701),
    BIRCH_BOAT(702),
    BIRCH_CHEST_BOAT(703),
    JUNGLE_BOAT(704),
    JUNGLE_CHEST_BOAT(705),
    ACACIA_BOAT(706),
    ACACIA_CHEST_BOAT(707),
    DARK_OAK_BOAT(708),
    DARK_OAK_CHEST_BOAT(709),
    MANGROVE_BOAT(710),
    MANGROVE_CHEST_BOAT(711),
    STRUCTURE_BLOCK(712),
    JIGSAW(713),
    TURTLE_HELMET(714),
    SCUTE(715),
    FLINT_AND_STEEL(716),
    APPLE(717),
    BOW(718),
    ARROW(719),
    COAL(720),
    CHARCOAL(721),
    DIAMOND(722),
    EMERALD(723),
    LAPIS_LAZULI(724),
    QUARTZ(725),
    AMETHYST_SHARD(726),
    RAW_IRON(727),
    IRON_INGOT(728),
    RAW_COPPER(729),
    COPPER_INGOT(730),
    RAW_GOLD(731),
    GOLD_INGOT(732),
    NETHERITE_INGOT(733),
    NETHERITE_SCRAP(734),
    WOODEN_SWORD(735),
    WOODEN_SHOVEL(736),
    WOODEN_PICKAXE(737),
    WOODEN_AXE(738),
    WOODEN_HOE(739),
    STONE_SWORD(740),
    STONE_SHOVEL(741),
    STONE_PICKAXE(742),
    STONE_AXE(743),
    STONE_HOE(744),
    GOLDEN_SWORD(745),
    GOLDEN_SHOVEL(746),
    GOLDEN_PICKAXE(747),
    GOLDEN_AXE(748),
    GOLDEN_HOE(749),
    IRON_SWORD(750),
    IRON_SHOVEL(751),
    IRON_PICKAXE(752),
    IRON_AXE(753),
    IRON_HOE(754),
    DIAMOND_SWORD(755),
    DIAMOND_SHOVEL(756),
    DIAMOND_PICKAXE(757),
    DIAMOND_AXE(758),
    DIAMOND_HOE(759),
    NETHERITE_SWORD(760),
    NETHERITE_SHOVEL(761),
    NETHERITE_PICKAXE(762),
    NETHERITE_AXE(763),
    NETHERITE_HOE(764),
    STICK(765),
    BOWL(766),
    MUSHROOM_STEW(767),
    STRING(768),
    FEATHER(769),
    GUNPOWDER(770),
    WHEAT_SEEDS(771),
    WHEAT(772),
    BREAD(773),
    LEATHER_HELMET(774),
    LEATHER_CHESTPLATE(775),
    LEATHER_LEGGINGS(776),
    LEATHER_BOOTS(777),
    CHAINMAIL_HELMET(778),
    CHAINMAIL_CHESTPLATE(779),
    CHAINMAIL_LEGGINGS(780),
    CHAINMAIL_BOOTS(781),
    IRON_HELMET(782),
    IRON_CHESTPLATE(783),
    IRON_LEGGINGS(784),
    IRON_BOOTS(785),
    DIAMOND_HELMET(786),
    DIAMOND_CHESTPLATE(787),
    DIAMOND_LEGGINGS(788),
    DIAMOND_BOOTS(789),
    GOLDEN_HELMET(790),
    GOLDEN_CHESTPLATE(791),
    GOLDEN_LEGGINGS(792),
    GOLDEN_BOOTS(793),
    NETHERITE_HELMET(794),
    NETHERITE_CHESTPLATE(795),
    NETHERITE_LEGGINGS(796),
    NETHERITE_BOOTS(797),
    FLINT(798),
    PORKCHOP(799),
    COOKED_PORKCHOP(800),
    PAINTING(801),
    GOLDEN_APPLE(802),
    ENCHANTED_GOLDEN_APPLE(803),
    OAK_SIGN(804),
    SPRUCE_SIGN(805),
    BIRCH_SIGN(806),
    JUNGLE_SIGN(807),
    ACACIA_SIGN(808),
    DARK_OAK_SIGN(809),
    MANGROVE_SIGN(810),
    CRIMSON_SIGN(811),
    WARPED_SIGN(812),
    BUCKET(813),
    WATER_BUCKET(814),
    LAVA_BUCKET(815),
    POWDER_SNOW_BUCKET(816),
    SNOWBALL(817),
    LEATHER(818),
    MILK_BUCKET(819),
    PUFFERFISH_BUCKET(820),
    SALMON_BUCKET(821),
    COD_BUCKET(822),
    TROPICAL_FISH_BUCKET(823),
    AXOLOTL_BUCKET(824),
    TADPOLE_BUCKET(825),
    BRICK(826),
    CLAY_BALL(827),
    DRIED_KELP_BLOCK(828),
    PAPER(829),
    BOOK(830),
    SLIME_BALL(831),
    EGG(832),
    COMPASS(833),
    RECOVERY_COMPASS(834),
    BUNDLE(835),
    FISHING_ROD(836),
    CLOCK(837),
    SPYGLASS(838),
    GLOWSTONE_DUST(839),
    COD(840),
    SALMON(841),
    TROPICAL_FISH(842),
    PUFFERFISH(843),
    COOKED_COD(844),
    COOKED_SALMON(845),
    INK_SAC(846),
    GLOW_INK_SAC(847),
    COCOA_BEANS(848),
    WHITE_DYE(849),
    ORANGE_DYE(850),
    MAGENTA_DYE(851),
    LIGHT_BLUE_DYE(852),
    YELLOW_DYE(853),
    LIME_DYE(854),
    PINK_DYE(855),
    GRAY_DYE(856),
    LIGHT_GRAY_DYE(857),
    CYAN_DYE(858),
    PURPLE_DYE(859),
    BLUE_DYE(860),
    BROWN_DYE(861),
    GREEN_DYE(862),
    RED_DYE(863),
    BLACK_DYE(864),
    BONE_MEAL(865),
    BONE(866),
    SUGAR(867),
    CAKE(868),
    WHITE_BED(869),
    ORANGE_BED(870),
    MAGENTA_BED(871),
    LIGHT_BLUE_BED(872),
    YELLOW_BED(873),
    LIME_BED(874),
    PINK_BED(875),
    GRAY_BED(876),
    LIGHT_GRAY_BED(877),
    CYAN_BED(878),
    PURPLE_BED(879),
    BLUE_BED(880),
    BROWN_BED(881),
    GREEN_BED(882),
    RED_BED(883),
    BLACK_BED(884),
    COOKIE(885),
    FILLED_MAP(886),
    SHEARS(887),
    MELON_SLICE(888),
    DRIED_KELP(889),
    PUMPKIN_SEEDS(890),
    MELON_SEEDS(891),
    BEEF(892),
    COOKED_BEEF(893),
    CHICKEN(894),
    COOKED_CHICKEN(895),
    ROTTEN_FLESH(896),
    ENDER_PEARL(897),
    BLAZE_ROD(898),
    GHAST_TEAR(899),
    GOLD_NUGGET(900),
    NETHER_WART(901),
    POTION(902),
    GLASS_BOTTLE(903),
    SPIDER_EYE(904),
    FERMENTED_SPIDER_EYE(905),
    BLAZE_POWDER(906),
    MAGMA_CREAM(907),
    BREWING_STAND(908),
    CAULDRON(909),
    ENDER_EYE(910),
    GLISTERING_MELON_SLICE(911),
    ALLAY_SPAWN_EGG(912),
    AXOLOTL_SPAWN_EGG(913),
    BAT_SPAWN_EGG(914),
    BEE_SPAWN_EGG(915),
    BLAZE_SPAWN_EGG(916),
    CAT_SPAWN_EGG(917),
    CAVE_SPIDER_SPAWN_EGG(918),
    CHICKEN_SPAWN_EGG(919),
    COD_SPAWN_EGG(920),
    COW_SPAWN_EGG(921),
    CREEPER_SPAWN_EGG(922),
    DOLPHIN_SPAWN_EGG(923),
    DONKEY_SPAWN_EGG(924),
    DROWNED_SPAWN_EGG(925),
    ELDER_GUARDIAN_SPAWN_EGG(926),
    ENDERMAN_SPAWN_EGG(927),
    ENDERMITE_SPAWN_EGG(928),
    EVOKER_SPAWN_EGG(929),
    FOX_SPAWN_EGG(930),
    FROG_SPAWN_EGG(931),
    GHAST_SPAWN_EGG(932),
    GLOW_SQUID_SPAWN_EGG(933),
    GOAT_SPAWN_EGG(934),
    GUARDIAN_SPAWN_EGG(935),
    HOGLIN_SPAWN_EGG(936),
    HORSE_SPAWN_EGG(937),
    HUSK_SPAWN_EGG(938),
    LLAMA_SPAWN_EGG(939),
    MAGMA_CUBE_SPAWN_EGG(940),
    MOOSHROOM_SPAWN_EGG(941),
    MULE_SPAWN_EGG(942),
    OCELOT_SPAWN_EGG(943),
    PANDA_SPAWN_EGG(944),
    PARROT_SPAWN_EGG(945),
    PHANTOM_SPAWN_EGG(946),
    PIG_SPAWN_EGG(947),
    PIGLIN_SPAWN_EGG(948),
    PIGLIN_BRUTE_SPAWN_EGG(949),
    PILLAGER_SPAWN_EGG(950),
    POLAR_BEAR_SPAWN_EGG(951),
    PUFFERFISH_SPAWN_EGG(952),
    RABBIT_SPAWN_EGG(953),
    RAVAGER_SPAWN_EGG(954),
    SALMON_SPAWN_EGG(955),
    SHEEP_SPAWN_EGG(956),
    SHULKER_SPAWN_EGG(957),
    SILVERFISH_SPAWN_EGG(958),
    SKELETON_SPAWN_EGG(959),
    SKELETON_HORSE_SPAWN_EGG(960),
    SLIME_SPAWN_EGG(961),
    SPIDER_SPAWN_EGG(962),
    SQUID_SPAWN_EGG(963),
    STRAY_SPAWN_EGG(964),
    STRIDER_SPAWN_EGG(965),
    TADPOLE_SPAWN_EGG(966),
    TRADER_LLAMA_SPAWN_EGG(967),
    TROPICAL_FISH_SPAWN_EGG(968),
    TURTLE_SPAWN_EGG(969),
    VEX_SPAWN_EGG(970),
    VILLAGER_SPAWN_EGG(971),
    VINDICATOR_SPAWN_EGG(972),
    WANDERING_TRADER_SPAWN_EGG(973),
    WARDEN_SPAWN_EGG(974),
    WITCH_SPAWN_EGG(975),
    WITHER_SKELETON_SPAWN_EGG(976),
    WOLF_SPAWN_EGG(977),
    ZOGLIN_SPAWN_EGG(978),
    ZOMBIE_SPAWN_EGG(979),
    ZOMBIE_HORSE_SPAWN_EGG(980),
    ZOMBIE_VILLAGER_SPAWN_EGG(981),
    ZOMBIFIED_PIGLIN_SPAWN_EGG(982),
    EXPERIENCE_BOTTLE(983),
    FIRE_CHARGE(984),
    WRITABLE_BOOK(985),
    WRITTEN_BOOK(986),
    ITEM_FRAME(987),
    GLOW_ITEM_FRAME(988),
    FLOWER_POT(989),
    CARROT(990),
    POTATO(991),
    BAKED_POTATO(992),
    POISONOUS_POTATO(993),
    MAP(994),
    GOLDEN_CARROT(995),
    SKELETON_SKULL(996),
    WITHER_SKELETON_SKULL(997),
    PLAYER_HEAD(998),
    ZOMBIE_HEAD(999),
    CREEPER_HEAD(1000),
    DRAGON_HEAD(1001),
    NETHER_STAR(1002),
    PUMPKIN_PIE(1003),
    FIREWORK_ROCKET(1004),
    FIREWORK_STAR(1005),
    ENCHANTED_BOOK(1006),
    NETHER_BRICK(1007),
    PRISMARINE_SHARD(1008),
    PRISMARINE_CRYSTALS(1009),
    RABBIT(1010),
    COOKED_RABBIT(1011),
    RABBIT_STEW(1012),
    RABBIT_FOOT(1013),
    RABBIT_HIDE(1014),
    ARMOR_STAND(1015),
    IRON_HORSE_ARMOR(1016),
    GOLDEN_HORSE_ARMOR(1017),
    DIAMOND_HORSE_ARMOR(1018),
    LEATHER_HORSE_ARMOR(1019),
    LEAD(1020),
    NAME_TAG(1021),
    COMMAND_BLOCK_MINECART(1022),
    MUTTON(1023),
    COOKED_MUTTON(1024),
    WHITE_BANNER(1025),
    ORANGE_BANNER(1026),
    MAGENTA_BANNER(1027),
    LIGHT_BLUE_BANNER(1028),
    YELLOW_BANNER(1029),
    LIME_BANNER(1030),
    PINK_BANNER(1031),
    GRAY_BANNER(1032),
    LIGHT_GRAY_BANNER(1033),
    CYAN_BANNER(1034),
    PURPLE_BANNER(1035),
    BLUE_BANNER(1036),
    BROWN_BANNER(1037),
    GREEN_BANNER(1038),
    RED_BANNER(1039),
    BLACK_BANNER(1040),
    END_CRYSTAL(1041),
    CHORUS_FRUIT(1042),
    POPPED_CHORUS_FRUIT(1043),
    BEETROOT(1044),
    BEETROOT_SEEDS(1045),
    BEETROOT_SOUP(1046),
    DRAGON_BREATH(1047),
    SPLASH_POTION(1048),
    SPECTRAL_ARROW(1049),
    TIPPED_ARROW(1050),
    LINGERING_POTION(1051),
    SHIELD(1052),
    TOTEM_OF_UNDYING(1053),
    SHULKER_SHELL(1054),
    IRON_NUGGET(1055),
    KNOWLEDGE_BOOK(1056),
    DEBUG_STICK(1057),
    MUSIC_DISC_13(1058),
    MUSIC_DISC_CAT(1059),
    MUSIC_DISC_BLOCKS(1060),
    MUSIC_DISC_CHIRP(1061),
    MUSIC_DISC_FAR(1062),
    MUSIC_DISC_MALL(1063),
    MUSIC_DISC_MELLOHI(1064),
    MUSIC_DISC_STAL(1065),
    MUSIC_DISC_STRAD(1066),
    MUSIC_DISC_WARD(1067),
    MUSIC_DISC_11(1068),
    MUSIC_DISC_WAIT(1069),
    MUSIC_DISC_OTHERSIDE(1070),
    MUSIC_DISC_5(1071),
    MUSIC_DISC_PIGSTEP(1072),
    DISC_FRAGMENT_5(1073),
    TRIDENT(1074),
    PHANTOM_MEMBRANE(1075),
    NAUTILUS_SHELL(1076),
    HEART_OF_THE_SEA(1077),
    CROSSBOW(1078),
    SUSPICIOUS_STEW(1079),
    LOOM(1080),
    FLOWER_BANNER_PATTERN(1081),
    CREEPER_BANNER_PATTERN(1082),
    SKULL_BANNER_PATTERN(1083),
    MOJANG_BANNER_PATTERN(1084),
    GLOBE_BANNER_PATTERN(1085),
    PIGLIN_BANNER_PATTERN(1086),
    GOAT_HORN(1087),
    COMPOSTER(1088),
    BARREL(1089),
    SMOKER(1090),
    BLAST_FURNACE(1091),
    CARTOGRAPHY_TABLE(1092),
    FLETCHING_TABLE(1093),
    GRINDSTONE(1094),
    SMITHING_TABLE(1095),
    STONECUTTER(1096),
    BELL(1097),
    LANTERN(1098),
    SOUL_LANTERN(1099),
    SWEET_BERRIES(1100),
    GLOW_BERRIES(1101),
    CAMPFIRE(1102),
    SOUL_CAMPFIRE(1103),
    SHROOMLIGHT(1104),
    HONEYCOMB(1105),
    BEE_NEST(1106),
    BEEHIVE(1107),
    HONEY_BOTTLE(1108),
    HONEYCOMB_BLOCK(1109),
    LODESTONE(1110),
    CRYING_OBSIDIAN(1111),
    BLACKSTONE(1112),
    BLACKSTONE_SLAB(1113),
    BLACKSTONE_STAIRS(1114),
    GILDED_BLACKSTONE(1115),
    POLISHED_BLACKSTONE(1116),
    POLISHED_BLACKSTONE_SLAB(1117),
    POLISHED_BLACKSTONE_STAIRS(1118),
    CHISELED_POLISHED_BLACKSTONE(1119),
    POLISHED_BLACKSTONE_BRICKS(1120),
    POLISHED_BLACKSTONE_BRICK_SLAB(1121),
    POLISHED_BLACKSTONE_BRICK_STAIRS(1122),
    CRACKED_POLISHED_BLACKSTONE_BRICKS(1123),
    RESPAWN_ANCHOR(1124),
    CANDLE(1125),
    WHITE_CANDLE(1126),
    ORANGE_CANDLE(1127),
    MAGENTA_CANDLE(1128),
    LIGHT_BLUE_CANDLE(1129),
    YELLOW_CANDLE(1130),
    LIME_CANDLE(1131),
    PINK_CANDLE(1132),
    GRAY_CANDLE(1133),
    LIGHT_GRAY_CANDLE(1134),
    CYAN_CANDLE(1135),
    PURPLE_CANDLE(1136),
    BLUE_CANDLE(1137),
    BROWN_CANDLE(1138),
    GREEN_CANDLE(1139),
    RED_CANDLE(1140),
    BLACK_CANDLE(1141),
    SMALL_AMETHYST_BUD(1142),
    MEDIUM_AMETHYST_BUD(1143),
    LARGE_AMETHYST_BUD(1144),
    AMETHYST_CLUSTER(1145),
    POINTED_DRIPSTONE(1146),
    OCHRE_FROGLIGHT(1147),
    VERDANT_FROGLIGHT(1148),
    PEARLESCENT_FROGLIGHT(1149),
    FROGSPAWN(1150),
    ECHO_SHARD(1151),
    WATER(1152),
    LAVA(1153),
    TALL_SEAGRASS(1154),
    PISTON_HEAD(1155),
    MOVING_PISTON(1156),
    WALL_TORCH(1157),
    FIRE(1158),
    SOUL_FIRE(1159),
    REDSTONE_WIRE(1160),
    OAK_WALL_SIGN(1161),
    SPRUCE_WALL_SIGN(1162),
    BIRCH_WALL_SIGN(1163),
    ACACIA_WALL_SIGN(1164),
    JUNGLE_WALL_SIGN(1165),
    DARK_OAK_WALL_SIGN(1166),
    MANGROVE_WALL_SIGN(1167),
    REDSTONE_WALL_TORCH(1168),
    SOUL_WALL_TORCH(1169),
    NETHER_PORTAL(1170),
    ATTACHED_PUMPKIN_STEM(1171),
    ATTACHED_MELON_STEM(1172),
    PUMPKIN_STEM(1173),
    MELON_STEM(1174),
    WATER_CAULDRON(1175),
    LAVA_CAULDRON(1176),
    POWDER_SNOW_CAULDRON(1177),
    END_PORTAL(1178),
    COCOA(1179),
    TRIPWIRE(1180),
    POTTED_OAK_SAPLING(1181),
    POTTED_SPRUCE_SAPLING(1182),
    POTTED_BIRCH_SAPLING(1183),
    POTTED_JUNGLE_SAPLING(1184),
    POTTED_ACACIA_SAPLING(1185),
    POTTED_DARK_OAK_SAPLING(1186),
    POTTED_MANGROVE_PROPAGULE(1187),
    POTTED_FERN(1188),
    POTTED_DANDELION(1189),
    POTTED_POPPY(1190),
    POTTED_BLUE_ORCHID(1191),
    POTTED_ALLIUM(1192),
    POTTED_AZURE_BLUET(1193),
    POTTED_RED_TULIP(1194),
    POTTED_ORANGE_TULIP(1195),
    POTTED_WHITE_TULIP(1196),
    POTTED_PINK_TULIP(1197),
    POTTED_OXEYE_DAISY(1198),
    POTTED_CORNFLOWER(1199),
    POTTED_LILY_OF_THE_VALLEY(1200),
    POTTED_WITHER_ROSE(1201),
    POTTED_RED_MUSHROOM(1202),
    POTTED_BROWN_MUSHROOM(1203),
    POTTED_DEAD_BUSH(1204),
    POTTED_CACTUS(1205),
    CARROTS(1206),
    POTATOES(1207),
    SKELETON_WALL_SKULL(1208),
    WITHER_SKELETON_WALL_SKULL(1209),
    ZOMBIE_WALL_HEAD(1210),
    PLAYER_WALL_HEAD(1211),
    CREEPER_WALL_HEAD(1212),
    DRAGON_WALL_HEAD(1213),
    WHITE_WALL_BANNER(1214),
    ORANGE_WALL_BANNER(1215),
    MAGENTA_WALL_BANNER(1216),
    LIGHT_BLUE_WALL_BANNER(1217),
    YELLOW_WALL_BANNER(1218),
    LIME_WALL_BANNER(1219),
    PINK_WALL_BANNER(1220),
    GRAY_WALL_BANNER(1221),
    LIGHT_GRAY_WALL_BANNER(1222),
    CYAN_WALL_BANNER(1223),
    PURPLE_WALL_BANNER(1224),
    BLUE_WALL_BANNER(1225),
    BROWN_WALL_BANNER(1226),
    GREEN_WALL_BANNER(1227),
    RED_WALL_BANNER(1228),
    BLACK_WALL_BANNER(1229),
    BEETROOTS(1230),
    END_GATEWAY(1231),
    FROSTED_ICE(1232),
    KELP_PLANT(1233),
    DEAD_TUBE_CORAL_WALL_FAN(1234),
    DEAD_BRAIN_CORAL_WALL_FAN(1235),
    DEAD_BUBBLE_CORAL_WALL_FAN(1236),
    DEAD_FIRE_CORAL_WALL_FAN(1237),
    DEAD_HORN_CORAL_WALL_FAN(1238),
    TUBE_CORAL_WALL_FAN(1239),
    BRAIN_CORAL_WALL_FAN(1240),
    BUBBLE_CORAL_WALL_FAN(1241),
    FIRE_CORAL_WALL_FAN(1242),
    HORN_CORAL_WALL_FAN(1243),
    BAMBOO_SAPLING(1244),
    POTTED_BAMBOO(1245),
    VOID_AIR(1246),
    CAVE_AIR(1247),
    BUBBLE_COLUMN(1248),
    SWEET_BERRY_BUSH(1249),
    WEEPING_VINES_PLANT(1250),
    TWISTING_VINES_PLANT(1251),
    CRIMSON_WALL_SIGN(1252),
    WARPED_WALL_SIGN(1253),
    POTTED_CRIMSON_FUNGUS(1254),
    POTTED_WARPED_FUNGUS(1255),
    POTTED_CRIMSON_ROOTS(1256),
    POTTED_WARPED_ROOTS(1257),
    CANDLE_CAKE(1258),
    WHITE_CANDLE_CAKE(1259),
    ORANGE_CANDLE_CAKE(1260),
    MAGENTA_CANDLE_CAKE(1261),
    LIGHT_BLUE_CANDLE_CAKE(1262),
    YELLOW_CANDLE_CAKE(1263),
    LIME_CANDLE_CAKE(1264),
    PINK_CANDLE_CAKE(1265),
    GRAY_CANDLE_CAKE(1266),
    LIGHT_GRAY_CANDLE_CAKE(1267),
    CYAN_CANDLE_CAKE(1268),
    PURPLE_CANDLE_CAKE(1269),
    BLUE_CANDLE_CAKE(1270),
    BROWN_CANDLE_CAKE(1271),
    GREEN_CANDLE_CAKE(1272),
    RED_CANDLE_CAKE(1273),
    BLACK_CANDLE_CAKE(1274),
    POWDER_SNOW(1275),
    CAVE_VINES(1276),
    CAVE_VINES_PLANT(1277),
    BIG_DRIPLEAF_STEM(1278),
    POTTED_AZALEA_BUSH(1279),
    POTTED_FLOWERING_AZALEA_BUSH(1280);

    override fun getNameKey(): String = "minecraft:${name.lowercase()}"
    override fun getName(): String = this.name
}