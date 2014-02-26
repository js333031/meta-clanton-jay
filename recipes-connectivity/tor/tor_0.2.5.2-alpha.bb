DESCRIPTION = "TOR project"
SECTION = "examples"
LICENSE = "GPLv3+"
SRC_URI[md5sum] = "5bc071d506f723a626a7b2a6fec20ae0"
SRC_URI[sha256sum] = "32a1d6dbfa4527fdaebfcb093f1d35cf464877b83b717a2ee0031e4f1f85b805"
LIC_FILES_CHKSUM = "file://LICENSE;md5=d5601db6c1fc95a0f938a69101c505aa"
PR = "r0"
SRC_URI = "https://www.torproject.org/dist/tor-${PV}.tar.gz"
DEPENDS = "libevent openssl"
inherit autotools gettext 


#EXTRA_OECONF = "--with-libc --enable-ipv6 --with-libssl-prefix=${STAGING_DIR_HOST} \
#                --with-ssl=openssl --disable-rpath --disable-iri"


do_install_append () {

cat > ${D}${sysconfdir}/tor/torrc <<EOF

SocksPort 9050 # Default: Bind to localhost:9050 for local connections.
SocksPort 192.168.2.134:9050 # Bind to this address:port too.

SocksPolicy accept 192.168.2.0/24

EOF
}

