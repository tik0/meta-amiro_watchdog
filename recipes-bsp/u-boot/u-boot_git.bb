require recipes-bsp/u-boot/u-boot.inc

# To build u-boot for your machine, provide the following lines in
# your machine config, replacing the assignments as appropriate for
# your machine.
# UBOOT_MACHINE = "omap3_beagle_defconfig"
# UBOOT_ENTRYPOINT = "0x80008000"
# UBOOT_LOADADDRESS = "0x80008000"

LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://Licenses/gpl-2.0.txt;md5=b234ee4d69f5fce4486a80fdaf4a4263"

SRCREV = "461be2f96e4b87e5065208c6659a47dd0ad9e9f8"

PV = "v2014.10+git${SRCPV}"

SRC_URI = "git://git.denx.de/u-boot.git;branch=master;protocol=git"

SRC_URI_append_amiro = " \
    file://0001-omap3-overo-Fix-fdtfile-test.patch \
    file://0002-omap3-overo-Call-bootm-only-after-successful-nand-re.patch \
    file://0003-omap3-overo-Move-ethernet-setup-to-board_eth_init-fu.patch \
    file://0004-omap3-overo-Separate-module-and-expansion-board-MUX-.patch \
    file://0005-omap3-overo-Add-usb-host-support.patch \
"

S = "${WORKDIR}/git"

PACKAGE_ARCH = "${MACHINE_ARCH}"

COMPATIBLE_MACHINE_amiro = "amiro"
