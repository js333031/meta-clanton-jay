FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRC_URI += "file://wpa_supplicant.jay.conf"

do_install_append() {
     install -m 644 ${WORKDIR}/wpa_supplicant.jay.conf ${D}${sysconfdir}/wpa_supplicant.conf
}
