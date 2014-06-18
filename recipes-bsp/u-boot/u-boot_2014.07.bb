require recipes-bsp/u-boot/u-boot.inc

# To build u-boot for your machine, provide the following lines in
# your machine config, replacing the assignments as appropriate for
# your machine.
# UBOOT_MACHINE = "omap3_beagle_config"
# UBOOT_ENTRYPOINT = "0x80008000"
# UBOOT_LOADADDRESS = "0x80008000"

LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://Licenses/gpl-2.0.txt;md5=b234ee4d69f5fce4486a80fdaf4a4263"

# This revision corresponds to the tag "v2012.04.01"
# We use the revision in order to avoid having to fetch it from the
# repo during parse
SRCREV = "3fe1a8545b55d31a6db2d9e60d962c4f6e048913"

PV = "v2014.07+git${SRCPV}"

SRC_URI = "git://git.denx.de/u-boot.git;branch=master;protocol=git"

SRC_URI_append_amiro = " \
    file://0001-omap3-overo-Add-usb-host-support.patch \
    file://0002-omap3-overo-Call-bootm-only-after-successful-nand-re.patch \
    file://0003-omap3-overo-Generate-USB-mac-from-die-id.patch \
    file://0004-omap3-overo-Change-GUMSTIX_NO_EEPROM-to-differ-from-.patch \
    file://0005-omap3-overo-Separate-overo-module-and-expansion-boar.patch \
    file://0008-Fix-hush-to-give-the-correct-return-code-for-a-simpl.patch \
    "

S = "${WORKDIR}/git"

PACKAGE_ARCH = "${MACHINE_ARCH}"

COMPATIBLE_MACHINE_amiro = "amiro"
