FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

KMACHINE_amiro = "amiro"

SRC_URI_append_amiro = " \
    file://amiro-standard.scc \
    file://amiro.cfg \
    file://0001-ARM-dts-overo-reorganize-include-files.patch \
    file://0002-ARM-dts-omap3-tobi-Add-missing-pinctrl.patch \
    file://0003-ARM-dts-omap3-overo-Add-missing-pinctrl.patch \
    file://0004-ARM-dts-omap3-overo-Enable-WiFi-BT-combo.patch \
    file://0005-ARM-dts-omap3-overo-Add-HSUSB-PHY.patch \
    file://0006-ARM-dts-omap-Add-common-file-for-SMSC9221.patch \
    file://0007-ARM-dts-omap3-tobi-Use-include-file-omap-gpmc-smsc92.patch \
    file://0008-ARM-dts-omap3-tobi-Add-AT24C01-EEPROM.patch \
    file://0009-ARM-dts-overo-Push-uart3-pinmux-down-to-expansion-bo.patch \
    file://0010-ARM-dts-overo-Create-a-file-for-common-Gumstix-perip.patch \
    file://0011-ARM-dts-overo-Add-LIS33DE-accelerometer.patch \
    file://0012-ARM-dts-Add-support-for-the-Overo-Palo43.patch \
    file://0013-ARM-dts-Add-support-for-the-Overo-Gallop43.patch \
    file://0014-ARM-dts-Add-support-for-the-Overo-Alto35.patch \
    file://0015-ARM-dts-Add-support-for-the-Overo-Chestnut43.patch \
    file://0016-ARM-dts-Add-support-for-the-Overo-Summit.patch \
    file://0017-ARM-OMAP3-clock-Back-propagate-rate-change-from-cam_.patch \
    file://0018-ARM-dts-fix-DPLL4-x2-clkouts-on-3630.patch \
    file://0019-ARM-dts-use-ti-fixed-factor-clock-for-dpll4_m5x2_mul.patch \
    file://0020-ARM-dts-set-ti-set-rate-parent-for-dpll4_m5-path.patch \
    file://0021-ARM-dts-set-ti-set-rate-parent-for-dpll4_m5x2-clock.patch \
    file://0022-ARM-dts-omap3-overo-Move-LIS33-accelerometer-to-its-.patch \
    file://0023-sound-Add-tpa2012-audio-amplifier.patch \
    file://0024-net-can-mcp251x-Add-reset-gpio.patch \
    file://0025-omap3-Add-overo-amiro-expansion-board-support.patch \
    "

#    file://0082-media-omap3isp-implement-ENUM_FMT.patch
#    file://0083-media-omap3isp-support-G_FMT.patch


COMPATIBLE_MACHINE_amiro = "amiro"

KERNEL_FEATURES_append = " ${@bb.utils.contains("DISTRO_FEATURES", "systemd", " systemd.scc", "" ,d)}"

