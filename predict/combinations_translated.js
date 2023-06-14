const combinations = {
  0: {
    '': '0',
    id: '0',
    Disease: 'Reaksi Obat',
    Description:
      'Reaksi obat yang merugikan (ADR) adalah cedera yang disebabkan oleh minum obat. ADRs dapat terjadi setelah penggunaan dosis tunggal atau pemberian obat yang berkepanjangan atau hasil dari kombinasi dua atau lebih obat.',
    Precaution:
      'hentikan iritasi, konsultasikan ke rumah sakit terdekat, hentikan minum obat, tindak lanjuti',
  },
  1: {
    '': '1',
    id: '1',
    Disease: 'Malaria',
    Description:
      'Penyakit menular yang disebabkan oleh parasit protozoa dari keluarga Plasmodium yang dapat ditularkan melalui gigitan nyamuk Anopheles atau melalui jarum atau transfusi yang terkontaminasi. Malaria falciparum merupakan jenis yang paling mematikan.',
    Precaution:
      'Konsultasikan dengan rumah sakit terdekat, hindari makanan berminyak, hindari makanan non vegetarian, jauhkan nyamuk',
  },
  2: {
    '': '2',
    id: '2',
    Disease: 'Alergi',
    Description:
      'Alergi adalah respons sistem kekebalan terhadap zat asing yang biasanya tidak berbahaya bagi tubuh Anda. Alergi dapat berupa makanan tertentu, serbuk sari, atau bulu hewan peliharaan. Tugas sistem kekebalan Anda adalah membuat Anda tetap sehat dengan melawan patogen berbahaya.',
    Precaution:
      'oleskan calamine, tutupi area dengan perban, , gunakan es untuk mengompres gatal',
  },
  3: {
    '': '3',
    id: '3',
    Disease: 'Hipotiroidisme',
    Description:
      'Hipotiroidisme, disebut juga tiroid kurang aktif atau tiroid rendah, adalah gangguan pada sistem endokrin di mana kelenjar tiroid tidak menghasilkan cukup hormon tiroid.',
    Precaution: 'kurangi stres, olahraga, makan sehat, tidur nyenyak',
  },
  4: {
    '': '4',
    id: '4',
    Disease: 'Psoriasis',
    Description:
      'Psoriasis adalah kelainan kulit umum yang membentuk bercak tebal, merah, bergelombang yang ditutupi sisik keperakan. Mereka dapat muncul di mana saja, tetapi sebagian besar muncul di kulit kepala, siku, lutut, dan punggung bawah. Psoriasis tidak dapat ditularkan dari orang ke orang. Itu terkadang terjadi pada anggota keluarga yang sama.',
    Precaution:
      'cuci tangan dengan air sabun hangat, hentikan pendarahan menggunakan tekanan, konsultasikan dengan dokter, mandi garam',
  },
  5: {
    '': '5',
    id: '5',
    Disease: 'GERD',
    Description:
      'Penyakit refluks gastroesofagus, atau GERD, adalah gangguan pencernaan yang memengaruhi sfingter esofagus bagian bawah (LES), cincin otot antara kerongkongan dan perut. Banyak orang, termasuk wanita hamil, menderita mulas atau gangguan pencernaan asam yang disebabkan oleh GERD.',
    Precaution:
      'hindari makanan pedas berlemak, hindari berbaring setelah makan, jaga berat badan yang sehat, olahraga',
  },
  6: {
    '': '6',
    id: '6',
    Disease: 'kolestasis kronis',
    Description:
      'Penyakit kolestatik kronis, baik yang terjadi pada masa bayi, masa kanak-kanak atau dewasa, ditandai dengan transportasi asam empedu yang rusak dari hati ke usus, yang disebabkan oleh kerusakan primer pada epitel bilier dalam banyak kasus.',
    Precaution:
      'mandi air dingin, obat anti gatal, konsultasi ke dokter, makan sehat',
  },
  7: {
    '': '7',
    id: '7',
    Disease: 'hepatitis A',
    Description:
      'Hepatitis A adalah infeksi hati yang sangat menular yang disebabkan oleh virus hepatitis A. Virus ini adalah salah satu dari beberapa jenis virus hepatitis yang menyebabkan peradangan dan memengaruhi kemampuan fungsi hati Anda.',
    Precaution:
      'Konsultasi ke rumah sakit terdekat, cuci tangan sampai tuntas, hindari makanan pedas berlemak, obat-obatan',
  },
  8: {
    '': '8',
    id: '8',
    Disease: 'Osteoartritis',
    Description:
      'Osteoarthritis adalah bentuk arthritis yang paling umum, mempengaruhi jutaan orang di seluruh dunia. Itu terjadi ketika tulang rawan pelindung yang melindungi ujung tulang Anda aus seiring waktu.',
    Precaution:
      'asetaminofen, konsultasi ke rumah sakit terdekat, tindak lanjut, mandi garam',
  },
  9: {
    '': '9',
    id: '9',
    Disease: '(Vertigo) Vertigo Posisi Paroksismal',
    Description:
      'Benign paroxysmal positional vertigo (BPPV) adalah salah satu penyebab vertigo yang paling umum \u2014 sensasi tiba-tiba bahwa Anda berputar atau bagian dalam kepala Anda berputar. Vertigo posisi paroksismal jinak menyebabkan episode singkat pusing ringan hingga intens.',
    Precaution:
      'berbaring, hindari perubahan tubuh yang tiba-tiba, hindari gerakan kepala yang tiba-tiba, rileks',
  },
  10: {
    '': '10',
    id: '10',
    Disease: 'Hipoglikemia',
    Description:
      'Hipoglikemia adalah suatu kondisi di mana kadar gula (glukosa) darah Anda lebih rendah dari normal. Glukosa adalah sumber energi utama tubuh Anda. Hipoglikemia sering dikaitkan dengan pengobatan diabetes. Tetapi obat lain dan berbagai kondisi \u2013 banyak yang jarang \u2013 dapat menyebabkan gula darah rendah pada orang yang tidak menderita diabetes.',
    Precaution:
      'berbaring miring, periksa denyut nadi, minum minuman manis, konsultasikan dengan dokter',
  },
  11: {
    '': '11',
    id: '11',
    Disease: 'Jerawat',
    Description:
      'Akne vulgaris adalah pembentukan komedo, papula, pustula, nodul, dan/atau kista akibat obstruksi dan inflamasi unit pilosebaceous (folikel rambut dan kelenjar sebaceous yang menyertainya). Jerawat berkembang di wajah dan tubuh bagian atas. Ini paling sering mempengaruhi remaja.',
    Precaution:
      'mandi dua kali, hindari makanan pedas berlemak, banyak minum air putih, hindari terlalu banyak produk',
  },
  12: {
    '': '12',
    id: '12',
    Disease: 'Diabetes',
    Description:
      'Diabetes adalah penyakit yang terjadi ketika glukosa darah Anda, juga disebut gula darah, terlalu tinggi. Glukosa darah adalah sumber energi utama Anda dan berasal dari makanan yang Anda makan. Insulin, hormon yang dibuat oleh pankreas, membantu glukosa dari makanan masuk ke sel Anda untuk digunakan sebagai energi.',
    Precaution: 'makan seimbang, olah raga, konsultasi ke dokter, follow up',
  },
  13: {
    '': '13',
    id: '13',
    Disease: 'Impetigo',
    Description:
      'Impetigo (im-puh-TIE-go) adalah infeksi kulit yang umum dan sangat menular yang terutama menyerang bayi dan anak-anak. Impetigo biasanya muncul sebagai luka merah di wajah, terutama di sekitar hidung dan mulut anak, serta di tangan dan kaki. Luka pecah dan mengembangkan kerak berwarna madu.',
    Precaution:
      'rendam area yang terkena dengan air hangat, gunakan antibiotik, hilangkan koreng dengan kain kompres basah, konsultasikan dengan dokter',
  },
  14: {
    '': '14',
    id: '14',
    Disease: 'Hipertensi',
    Description:
      'Hipertensi (HTN atau HT), juga dikenal sebagai tekanan darah tinggi (HBP), adalah kondisi medis jangka panjang di mana tekanan darah di arteri terus meningkat. Tekanan darah tinggi biasanya tidak menimbulkan gejala.',
    Precaution: 'meditasi, mandi garam, kurangi stres, tidur nyenyak',
  },
  15: {
    '': '15',
    id: '15',
    Disease: 'Penyakit ulkus peptikum',
    Description:
      'Penyakit ulkus peptikum (PUD) adalah robekan pada lapisan dalam lambung, bagian pertama dari usus kecil, atau terkadang esofagus bagian bawah. Ulkus di lambung disebut ulkus lambung, sedangkan ulkus di bagian pertama usus disebut ulkus duodenum.',
    Precaution:
      'hindari makanan pedas berlemak, konsumsi makanan probiotik, hilangkan susu, batasi alkohol',
  },
  16: {
    '': '16',
    id: '16',
    Disease: 'Wasir Dimorfik (Tumpukan)',
    Description:
      'Wasir, juga dieja wasir, adalah struktur vaskular di saluran anus. Dalam ... Nama lain, Wasir, wasir, penyakit ambeien .',
    Precaution:
      'hindari makanan pedas berlemak, konsumsi witch hazel, mandi air hangat dengan garam epsom, konsumsi jus alovera',
  },
  17: {
    '': '17',
    id: '17',
    Disease: 'Flu biasa',
    Description:
      'Pilek biasa adalah infeksi virus pada hidung dan tenggorokan (saluran pernapasan bagian atas). Biasanya tidak berbahaya, meski mungkin tidak terasa seperti itu. Banyak jenis virus yang dapat menyebabkan flu biasa.',
    Precaution:
      'minum minuman kaya vitamin c, minum uap, hindari makanan dingin, jaga demam',
  },
  18: {
    '': '18',
    id: '18',
    Disease: 'Cacar air',
    Description:
      'Cacar air adalah penyakit yang sangat menular yang disebabkan oleh virus varicella-zoster (VZV). Ini dapat menyebabkan ruam yang gatal dan seperti melepuh. Ruam pertama kali muncul di dada, punggung, dan wajah, lalu menyebar ke seluruh tubuh, menyebabkan 250 hingga 500 lepuh gatal.',
    Precaution:
      'gunakan mimba saat mandi, konsumsi daun mimba, vaksin, hindari tempat umum',
  },
  19: {
    '': '19',
    id: '19',
    Disease: 'spondilosis serviks',
    Description:
      'Spondylosis serviks adalah istilah umum untuk keausan terkait usia yang memengaruhi cakram tulang belakang di leher Anda. Saat cakram mengalami dehidrasi dan menyusut, tanda-tanda osteoartritis berkembang, termasuk tonjolan tulang di sepanjang tepi tulang (taji tulang).',
    Precaution:
      'gunakan bantalan pemanas atau kompres dingin, olahraga, minum pereda nyeri, konsultasikan dengan dokter',
  },
  20: {
    '': '20',
    id: '20',
    Disease: 'Hipertiroidisme',
    Description:
      'Hipertiroidisme (tiroid yang terlalu aktif) terjadi ketika kelenjar tiroid Anda menghasilkan terlalu banyak hormon tiroksin. Hipertiroidisme dapat mempercepat metabolisme tubuh Anda, menyebabkan penurunan berat badan yang tidak disengaja dan detak jantung yang cepat atau tidak teratur.',
    Precaution:
      'makan sehat, pijat, gunakan lemon balm, lakukan pengobatan yodium radioaktif',
  },
  21: {
    '': '21',
    id: '21',
    Disease: 'Infeksi saluran kemih',
    Description:
      'Infeksi saluran kemih: Infeksi pada ginjal, ureter, kandung kemih, atau uretra. UTI disingkat. Tidak semua orang dengan ISK memiliki gejala, tetapi gejala umumnya termasuk sering ingin buang air kecil dan nyeri atau rasa terbakar saat buang air kecil.',
    Precaution:
      'banyak minum air putih, perbanyak asupan vitamin c, minum jus cranberry, minum probiotik',
  },
  22: {
    '': '22',
    id: '22',
    Disease: 'Pembuluh mekar',
    Description:
      'Pembuluh darah yang membesar dan terpelintir, seringkali muncul sebagai pembuluh darah biru yang menonjol yang terlihat jelas melalui kulit. Varises paling sering terjadi pada orang dewasa yang lebih tua, terutama wanita, dan terjadi terutama pada kaki.',
    Precaution:
      'berbaring telentang dan angkat kaki tinggi-tinggi, gunakan salep, gunakan kompresi vena, jangan diam terlalu lama',
  },
  23: {
    '': '23',
    id: '23',
    Disease: 'AIDS',
    Description:
      'Acquired immunodeficiency syndrome (AIDS) adalah kondisi kronis yang berpotensi mengancam jiwa yang disebabkan oleh human immunodeficiency virus (HIV). Dengan merusak sistem kekebalan Anda, HIV mengganggu kemampuan tubuh Anda untuk melawan infeksi dan penyakit.',
    Precaution:
      'hindari luka terbuka, pakai APD jika memungkinkan, konsultasikan ke dokter, tindak lanjut',
  },
  24: {
    '': '24',
    id: '24',
    Disease: 'Kelumpuhan (pendarahan otak)',
    Description:
      'Perdarahan intraserebral (ICH) adalah ketika darah tiba-tiba masuk ke jaringan otak, menyebabkan kerusakan pada otak Anda. Gejala biasanya muncul tiba-tiba selama ICH. Mereka termasuk sakit kepala, kelemahan, kebingungan, dan kelumpuhan, terutama di satu sisi tubuh Anda.',
    Precaution: 'pijat, makan sehat, olah raga, konsultasi ke dokter',
  },
  25: {
    '': '25',
    id: '25',
    Disease: 'Penyakit tipus',
    Description:
      'Penyakit akut yang ditandai dengan demam yang disebabkan oleh infeksi bakteri Salmonella typhi. Demam tifoid memiliki onset yang berbahaya, dengan demam, sakit kepala, konstipasi, malaise, menggigil, dan nyeri otot. Diare jarang terjadi, dan muntah biasanya tidak parah.',
    Precaution:
      'makan sayuran berkalori tinggi, terapi antibiotik, konsultasi ke dokter, pengobatan',
  },
  26: {
    '': '26',
    id: '26',
    Disease: 'Hepatitis B',
    Description:
      'Hepatitis B adalah infeksi hati Anda. Ini dapat menyebabkan jaringan parut pada organ, gagal hati, dan kanker. Ini bisa berakibat fatal jika tidak diobati. Itu menyebar ketika orang bersentuhan dengan darah, luka terbuka, atau cairan tubuh seseorang yang memiliki virus hepatitis B.',
    Precaution:
      'konsultasi ke rumah sakit terdekat, vaksinasi, makan sehat, pengobatan',
  },
  27: {
    '': '27',
    id: '27',
    Disease: 'Infeksi jamur',
    Description:
      'Pada manusia, infeksi jamur terjadi ketika jamur yang menyerang mengambil alih area tubuh dan terlalu banyak untuk ditangani oleh sistem kekebalan tubuh. Jamur dapat hidup di udara, tanah, air, dan tumbuhan. Ada juga beberapa jamur yang hidup secara alami di dalam tubuh manusia. Seperti banyak mikroba, ada jamur yang bermanfaat dan jamur yang berbahaya.',
    Precaution:
      'mandi dua kali, gunakan dettol atau nimba dalam air mandi, jaga area yang terinfeksi tetap kering, gunakan pakaian bersih',
  },
  28: {
    '': '28',
    id: '28',
    Disease: 'Hepatitis C',
    Description:
      'Peradangan hati akibat virus hepatitis C (HCV), yang biasanya menyebar melalui transfusi darah (jarang), hemodialisis, dan jarum suntik. Kerusakan yang dilakukan hepatitis C pada hati dapat menyebabkan sirosis dan komplikasinya serta kanker.',
    Precaution:
      'Konsultasi ke rumah sakit terdekat, vaksinasi, makan sehat, pengobatan',
  },
  29: {
    '': '29',
    id: '29',
    Disease: 'Migrain',
    Description:
      'Migrain dapat menyebabkan nyeri berdenyut parah atau sensasi berdenyut, biasanya di satu sisi kepala. Ini sering disertai mual, muntah, dan kepekaan ekstrem terhadap cahaya dan suara. Serangan migrain bisa berlangsung berjam-jam hingga berhari-hari, dan rasa sakitnya bisa sangat parah sehingga mengganggu aktivitas Anda sehari-hari.',
    Precaution:
      'meditasi, kurangi stres, gunakan kacamata polaroid di bawah sinar matahari, konsultasikan ke dokter',
  },
  30: {
    '': '30',
    id: '30',
    Disease: 'Asma bronkial',
    Description:
      'Asma bronkial adalah kondisi medis yang menyebabkan saluran udara paru-paru membengkak dan menyempit. Akibat pembengkakan ini, saluran udara menghasilkan lendir berlebih sehingga sulit bernapas, yang mengakibatkan batuk, napas pendek, dan mengi. Penyakit ini kronis dan mengganggu pekerjaan sehari-hari.',
    Precaution:
      'beralih ke pakaian longgar, tarik napas dalam-dalam, menjauh dari pemicu, cari bantuan',
  },
  31: {
    '': '31',
    id: '31',
    Disease: 'Hepatitis alkoholik',
    Description:
      'Hepatitis alkoholik adalah penyakit, kondisi radang hati yang disebabkan oleh konsumsi alkohol yang berlebihan dalam jangka waktu yang lama. Ini juga diperburuk oleh pesta minuman keras dan penggunaan alkohol yang berkelanjutan. Jika Anda mengembangkan kondisi ini, Anda harus berhenti minum alkohol',
    Precaution:
      'hentikan konsumsi alkohol, konsultasikan dengan dokter, pengobatan, tindak lanjut',
  },
  32: {
    '': '32',
    id: '32',
    Disease: 'Penyakit kuning',
    Description:
      'Pewarnaan kuning pada kulit dan sklera (bagian putih mata) oleh kadar bilirubin pigmen empedu dalam darah yang sangat tinggi. Menguning meluas ke jaringan lain dan cairan tubuh. Penyakit kuning pernah disebut "morbus regius" (penyakit kerajaan) dengan keyakinan bahwa hanya sentuhan seorang raja yang dapat menyembuhkannya.',
    Precaution:
      'banyak minum air putih, konsumsi milk thistle, makan buah-buahan dan makanan berserat tinggi, obat-obatan',
  },
  33: {
    '': '33',
    id: '33',
    Disease: 'Hepatitis E',
    Description:
      'Suatu bentuk peradangan hati yang langka yang disebabkan oleh infeksi virus hepatitis E (HEV). Ini ditularkan melalui makanan atau minuman yang ditangani oleh orang yang terinfeksi atau melalui persediaan air yang terinfeksi di daerah di mana kotoran dapat masuk ke dalam air. Hepatitis E tidak menyebabkan penyakit hati kronis.',
    Precaution:
      'hentikan konsumsi alkohol, istirahat, konsultasikan dengan dokter, pengobatan',
  },
  34: {
    '': '34',
    id: '34',
    Disease: 'demam berdarah',
    Description:
      'penyakit menular akut yang disebabkan oleh flavivirus (spesies virus Dengue dari genus Flavivirus), ditularkan oleh nyamuk aedes, dan ditandai dengan sakit kepala, nyeri sendi yang parah, dan ruam. \u2014 Disebut juga demam patah tulang, demam berdarah.',
    Precaution:
      'minum jus daun pepaya, hindari makanan pedas berlemak, jauhkan nyamuk, tetap terhidrasi',
  },
  35: {
    '': '35',
    id: '35',
    Disease: 'Hepatitis D',
    Description:
      'Hepatitis D, juga dikenal sebagai virus hepatitis delta, adalah infeksi yang menyebabkan hati meradang. Pembengkakan ini dapat merusak fungsi hati dan menyebabkan masalah hati jangka panjang, termasuk jaringan parut hati dan kanker. Kondisi ini disebabkan oleh virus hepatitis D (HDV).',
    Precaution:
      'konsultasikan dengan dokter, pengobatan, makan sehat, tindak lanjut',
  },
  36: {
    '': '36',
    id: '36',
    Disease: 'Serangan jantung',
    Description:
      'Kematian otot jantung karena hilangnya suplai darah. Hilangnya suplai darah biasanya disebabkan oleh penyumbatan total arteri koroner, salah satu arteri yang memasok darah ke otot jantung.',
    Precaution: 'panggil ambulans, kunyah atau telan asprin, tetap tenang,',
  },
  37: {
    '': '37',
    id: '37',
    Disease: 'Radang paru-paru',
    Description:
      'Pneumonia adalah infeksi pada salah satu atau kedua paru-paru. Bakteri, virus, dan jamur menyebabkannya. Infeksi menyebabkan peradangan pada kantung udara di paru-paru Anda, yang disebut alveoli. Alveoli terisi cairan atau nanah, sehingga sulit bernapas.',
    Precaution:
      'konsultasikan dengan dokter, pengobatan, istirahat, tindak lanjut',
  },
  38: {
    '': '38',
    id: '38',
    Disease: 'Radang sendi',
    Description:
      'Arthritis adalah pembengkakan dan nyeri pada satu atau lebih persendian Anda. Gejala utama radang sendi adalah nyeri sendi dan kekakuan, yang biasanya memburuk seiring bertambahnya usia. Jenis arthritis yang paling umum adalah osteoarthritis dan rheumatoid arthritis.',
    Precaution:
      'olahraga, gunakan terapi panas dan dingin, coba akupunktur, pijat',
  },
  39: {
    '': '39',
    id: '39',
    Disease: 'Gastroenteritis',
    Description:
      'Gastroenteritis adalah peradangan pada saluran pencernaan, terutama lambung, dan usus besar dan kecil. Gastroenteritis virus dan bakteri adalah infeksi usus yang berhubungan dengan gejala diare, kram perut, mual, dan muntah.',
    Precaution:
      'berhenti makan makanan padat untuk sementara, coba minum sedikit air, istirahat, santai kembali makan',
  },
  40: {
    '': '40',
    id: '40',
    Disease: 'Tuberkulosis',
    Description:
      'Tuberkulosis (TB) adalah penyakit menular yang biasanya disebabkan oleh bakteri Mycobacterium tuberculosis (MTB). Tuberkulosis umumnya menyerang paru-paru, tetapi juga dapat menyerang bagian tubuh lainnya. Sebagian besar infeksi tidak menunjukkan gejala, dalam hal ini dikenal sebagai tuberkulosis laten.',
    Precaution:
      'tutup mulut, konsultasikan dengan dokter, obat-obatan, istirahat',
  },
};

module.exports = combinations;
