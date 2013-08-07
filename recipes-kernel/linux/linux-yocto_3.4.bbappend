FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

PRINC := "${@int(PRINC) + 1}"

KMACHINE_cerebric = "amiro"

SRC_URI += "file://amiro-standard.scc \
            file://amiro.cfg \
            file://1000-omap3_add_amiro_board_support.patch \
            file://1001-overo_add_amiro_i2c_config_eeprom.patch \
            file://0082-media-omap3isp-implement-ENUM_FMT.patch \
            file://0083-media-omap3isp-support-G_FMT.patch \
            "

COMPATIBLE_MACHINE_amiro = "amiro"
