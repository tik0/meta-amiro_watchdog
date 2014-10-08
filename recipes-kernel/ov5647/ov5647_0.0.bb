DESCRIPTION = "AMiRo OV5647"
SECTION = "kernel/modules"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://drivers/ov5647.c;beginline=1;endline=11;md5=e03504e91c7579dad3f38f1fa552005b"

SRC_URI = " \
    file://ov5647.tar.gz \
"

inherit module

S = "${WORKDIR}/${PN}"

COMPATIBLE_MACHINE_amiro = "amiro"
