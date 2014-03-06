DESCRIPTION = "An Open Source MQTT v3.1 Broker"
SECTION = "examples"
LICENSE = "GPLv3+"
SRC_URI[md5sum] = "0874beeff51b3c64d4a7b2d5f9498288"
SRC_URI[sha256sum] = "79b0c498b21294e310a2f88f28882f3633920245ff80f38d6879adfe9548580f"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=89aa5ea5f32e4260d84c5d185ee3add4"
PR = "r0"
SRC_URI = "http://mosquitto.org/files/source/mosquitto-${PV}.tar.gz \
           file://mosquitto.patch"

DEPENDS = "openssl"
inherit autotools 

CFLAGS += "-L${STAGING_LIBDIR}"

FILES_${PN} += "${libdir}/python2.7/*"

do_install_append () {

}

