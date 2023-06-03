const combinations = {
    "0": {
        "": "0",
        "id": "0",
        "Disease": "Drug Reaction",
        "Description": "An adverse drug reaction (ADR) is an injury caused by taking medication. ADRs may occur following a single dose or prolonged administration of a drug or result from the combination of two or more drugs.",
        "Precaution": "stop irritation, consult nearest hospital, stop taking drug, follow up"
    },
    "1": {
        "": "1",
        "id": "1",
        "Disease": "Malaria",
        "Description": "An infectious disease caused by protozoan parasites from the Plasmodium family that can be transmitted by the bite of the Anopheles mosquito or by a contaminated needle or transfusion. Falciparum malaria is the most deadly type.",
        "Precaution": "Consult nearest hospital, avoid oily food, avoid non veg food, keep mosquitos out"
    },
    "2": {
        "": "2",
        "id": "2",
        "Disease": "Allergy",
        "Description": "An allergy is an immune system response to a foreign substance that's not typically harmful to your body.They can include certain foods, pollen, or pet dander. Your immune system's job is to keep you healthy by fighting harmful pathogens.",
        "Precaution": "apply calamine, cover area with bandage, , use ice to compress itching"
    },
    "3": {
        "": "3",
        "id": "3",
        "Disease": "Hypothyroidism",
        "Description": "Hypothyroidism, also called underactive thyroid or low thyroid, is a disorder of the endocrine system in which the thyroid gland does not produce enough thyroid hormone.",
        "Precaution": "reduce stress, exercise, eat healthy, get proper sleep"
    },
    "4": {
        "": "4",
        "id": "4",
        "Disease": "Psoriasis",
        "Description": "Psoriasis is a common skin disorder that forms thick, red, bumpy patches covered with silvery scales. They can pop up anywhere, but most appear on the scalp, elbows, knees, and lower back. Psoriasis can't be passed from person to person. It does sometimes happen in members of the same family.",
        "Precaution": "wash hands with warm soapy water, stop bleeding using pressure, consult doctor, salt baths"
    },
    "5": {
        "": "5",
        "id": "5",
        "Disease": "GERD",
        "Description": "Gastroesophageal reflux disease, or GERD, is a digestive disorder that affects the lower esophageal sphincter (LES), the ring of muscle between the esophagus and stomach. Many people, including pregnant women, suffer from heartburn or acid indigestion caused by GERD.",
        "Precaution": "avoid fatty spicy food, avoid lying down after eating, maintain healthy weight, exercise"
    },
    "6": {
        "": "6",
        "id": "6",
        "Disease": "Chronic cholestasis",
        "Description": "Chronic cholestatic diseases, whether occurring in infancy, childhood or adulthood, are characterized by defective bile acid transport from the liver to the intestine, which is caused by primary damage to the biliary epithelium in most cases",
        "Precaution": "cold baths, anti itch medicine, consult doctor, eat healthy"
    },
    "7": {
        "": "7",
        "id": "7",
        "Disease": "hepatitis A",
        "Description": "Hepatitis A is a highly contagious liver infection caused by the hepatitis A virus. The virus is one of several types of hepatitis viruses that cause inflammation and affect your liver's ability to function.",
        "Precaution": "Consult nearest hospital, wash hands through, avoid fatty spicy food, medication"
    },
    "8": {
        "": "8",
        "id": "8",
        "Disease": "Osteoarthristis",
        "Description": "Osteoarthritis is the most common form of arthritis, affecting millions of people worldwide. It occurs when the protective cartilage that cushions the ends of your bones wears down over time.",
        "Precaution": "acetaminophen, consult nearest hospital, follow up, salt baths"
    },
    "9": {
        "": "9",
        "id": "9",
        "Disease": "(vertigo) Paroymsal  Positional Vertigo",
        "Description": "Benign paroxysmal positional vertigo (BPPV) is one of the most common causes of vertigo \u2014 the sudden sensation that you're spinning or that the inside of your head is spinning. Benign paroxysmal positional vertigo causes brief episodes of mild to intense dizziness.",
        "Precaution": "lie down, avoid sudden change in body, avoid abrupt head movment, relax"
    },
    "10": {
        "": "10",
        "id": "10",
        "Disease": "Hypoglycemia",
        "Description": "Hypoglycemia is a condition in which your blood sugar (glucose) level is lower than normal. Glucose is your body's main energy source. Hypoglycemia is often related to diabetes treatment. But other drugs and a variety of conditions \u2014 many rare \u2014 can cause low blood sugar in people who don't have diabetes.",
        "Precaution": "lie down on side, check in pulse, drink sugary drinks, consult doctor"
    },
    "11": {
        "": "11",
        "id": "11",
        "Disease": "Acne",
        "Description": "Acne vulgaris is the formation of comedones, papules, pustules, nodules, and/or cysts as a result of obstruction and inflammation of pilosebaceous units (hair follicles and their accompanying sebaceous gland). Acne develops on the face and upper trunk. It most often affects adolescents.",
        "Precaution": "bath twice, avoid fatty spicy food, drink plenty of water, avoid too many products"
    },
    "12": {
        "": "12",
        "id": "12",
        "Disease": "Diabetes",
        "Description": "Diabetes is a disease that occurs when your blood glucose, also called blood sugar, is too high. Blood glucose is your main source of energy and comes from the food you eat. Insulin, a hormone made by the pancreas, helps glucose from food get into your cells to be used for energy.",
        "Precaution": "have balanced diet, exercise, consult doctor, follow up"
    },
    "13": {
        "": "13",
        "id": "13",
        "Disease": "Impetigo",
        "Description": "Impetigo (im-puh-TIE-go) is a common and highly contagious skin infection that mainly affects infants and children. Impetigo usually appears as red sores on the face, especially around a child's nose and mouth, and on hands and feet. The sores burst and develop honey-colored crusts.",
        "Precaution": "soak affected area in warm water, use antibiotics, remove scabs with wet compressed cloth, consult doctor"
    },
    "14": {
        "": "14",
        "id": "14",
        "Disease": "Hypertension",
        "Description": "Hypertension (HTN or HT), also known as high blood pressure (HBP), is a long-term medical condition in which the blood pressure in the arteries is persistently elevated. High blood pressure typically does not cause symptoms.",
        "Precaution": "meditation, salt baths, reduce stress, get proper sleep"
    },
    "15": {
        "": "15",
        "id": "15",
        "Disease": "Peptic ulcer diseae",
        "Description": "Peptic ulcer disease (PUD) is a break in the inner lining of the stomach, the first part of the small intestine, or sometimes the lower esophagus. An ulcer in the stomach is called a gastric ulcer, while one in the first part of the intestines is a duodenal ulcer.",
        "Precaution": "avoid fatty spicy food, consume probiotic food, eliminate milk, limit alcohol"
    },
    "16": {
        "": "16",
        "id": "16",
        "Disease": "Dimorphic hemorrhoids (piles)",
        "Description": "Hemorrhoids, also spelled haemorrhoids, are vascular structures in the anal canal. In their ... Other names, Haemorrhoids, piles, hemorrhoidal disease .",
        "Precaution": "avoid fatty spicy food, consume witch hazel, warm bath with epsom salt, consume alovera juice"
    },
    "17": {
        "": "17",
        "id": "17",
        "Disease": "Common Cold",
        "Description": "The common cold is a viral infection of your nose and throat (upper respiratory tract). It's usually harmless, although it might not feel that way. Many types of viruses can cause a common cold.",
        "Precaution": "drink vitamin c rich drinks, take vapour, avoid cold food, keep fever in check"
    },
    "18": {
        "": "18",
        "id": "18",
        "Disease": "Chicken pox",
        "Description": "Chickenpox is a highly contagious disease caused by the varicella-zoster virus (VZV). It can cause an itchy, blister-like rash. The rash first appears on the chest, back, and face, and then spreads over the entire body, causing between 250 and 500 itchy blisters.",
        "Precaution": "use neem in bathing, consume neem leaves, take vaccine, avoid public places"
    },
    "19": {
        "": "19",
        "id": "19",
        "Disease": "Cervical spondylosis",
        "Description": "Cervical spondylosis is a general term for age-related wear and tear affecting the spinal disks in your neck. As the disks dehydrate and shrink, signs of osteoarthritis develop, including bony projections along the edges of bones (bone spurs).",
        "Precaution": "use heating pad or cold pack, exercise, take otc pain reliver, consult doctor"
    },
    "20": {
        "": "20",
        "id": "20",
        "Disease": "Hyperthyroidism",
        "Description": "Hyperthyroidism (overactive thyroid) occurs when your thyroid gland produces too much of the hormone thyroxine. Hyperthyroidism can accelerate your body's metabolism, causing unintentional weight loss and a rapid or irregular heartbeat.",
        "Precaution": "eat healthy, massage, use lemon balm, take radioactive iodine treatment"
    },
    "21": {
        "": "21",
        "id": "21",
        "Disease": "Urinary tract infection",
        "Description": "Urinary tract infection: An infection of the kidney, ureter, bladder, or urethra. Abbreviated UTI. Not everyone with a UTI has symptoms, but common symptoms include a frequent urge to urinate and pain or burning when urinating.",
        "Precaution": "drink plenty of water, increase vitamin c intake, drink cranberry juice, take probiotics"
    },
    "22": {
        "": "22",
        "id": "22",
        "Disease": "Varicose veins",
        "Description": "A vein that has enlarged and twisted, often appearing as a bulging, blue blood vessel that is clearly visible through the skin. Varicose veins are most common in older adults, particularly women, and occur especially on the legs.",
        "Precaution": "lie down flat and raise the leg high, use oinments, use vein compression, dont stand still for long"
    },
    "23": {
        "": "23",
        "id": "23",
        "Disease": "AIDS",
        "Description": "Acquired immunodeficiency syndrome (AIDS) is a chronic, potentially life-threatening condition caused by the human immunodeficiency virus (HIV). By damaging your immune system, HIV interferes with your body's ability to fight infection and disease.",
        "Precaution": "avoid open cuts, wear ppe if possible, consult doctor, follow up"
    },
    "24": {
        "": "24",
        "id": "24",
        "Disease": "Paralysis (brain hemorrhage)",
        "Description": "Intracerebral hemorrhage (ICH) is when blood suddenly bursts into brain tissue, causing damage to your brain. Symptoms usually appear suddenly during ICH. They include headache, weakness, confusion, and paralysis, particularly on one side of your body.",
        "Precaution": "massage, eat healthy, exercise, consult doctor"
    },
    "25": {
        "": "25",
        "id": "25",
        "Disease": "Typhoid",
        "Description": "An acute illness characterized by fever caused by infection with the bacterium Salmonella typhi. Typhoid fever has an insidious onset, with fever, headache, constipation, malaise, chills, and muscle pain. Diarrhea is uncommon, and vomiting is not usually severe.",
        "Precaution": "eat high calorie vegitables, antiboitic therapy, consult doctor, medication"
    },
    "26": {
        "": "26",
        "id": "26",
        "Disease": "Hepatitis B",
        "Description": "Hepatitis B is an infection of your liver. It can cause scarring of the organ, liver failure, and cancer. It can be fatal if it isn't treated. It's spread when people come in contact with the blood, open sores, or body fluids of someone who has the hepatitis B virus.",
        "Precaution": "consult nearest hospital, vaccination, eat healthy, medication"
    },
    "27": {
        "": "27",
        "id": "27",
        "Disease": "Fungal infection",
        "Description": "In humans, fungal infections occur when an invading fungus takes over an area of the body and is too much for the immune system to handle. Fungi can live in the air, soil, water, and plants. There are also some fungi that live naturally in the human body. Like many microbes, there are helpful fungi and harmful fungi.",
        "Precaution": "bath twice, use detol or neem in bathing water, keep infected area dry, use clean cloths"
    },
    "28": {
        "": "28",
        "id": "28",
        "Disease": "Hepatitis C",
        "Description": "Inflammation of the liver due to the hepatitis C virus (HCV), which is usually spread via blood transfusion (rare), hemodialysis, and needle sticks. The damage hepatitis C does to the liver can lead to cirrhosis and its complications as well as cancer.",
        "Precaution": "Consult nearest hospital, vaccination, eat healthy, medication"
    },
    "29": {
        "": "29",
        "id": "29",
        "Disease": "Migraine",
        "Description": "A migraine can cause severe throbbing pain or a pulsing sensation, usually on one side of the head. It's often accompanied by nausea, vomiting, and extreme sensitivity to light and sound. Migraine attacks can last for hours to days, and the pain can be so severe that it interferes with your daily activities.",
        "Precaution": "meditation, reduce stress, use poloroid glasses in sun, consult doctor"
    },
    "30": {
        "": "30",
        "id": "30",
        "Disease": "Bronchial Asthma",
        "Description": "Bronchial asthma is a medical condition which causes the airway path of the lungs to swell and narrow. Due to this swelling, the air path produces excess mucus making it hard to breathe, which results in coughing, short breath, and wheezing. The disease is chronic and interferes with daily working.",
        "Precaution": "switch to loose cloothing, take deep breaths, get away from trigger, seek help"
    },
    "31": {
        "": "31",
        "id": "31",
        "Disease": "Alcoholic hepatitis",
        "Description": "Alcoholic hepatitis is a diseased, inflammatory condition of the liver caused by heavy alcohol consumption over an extended period of time. It's also aggravated by binge drinking and ongoing alcohol use. If you develop this condition, you must stop drinking alcohol",
        "Precaution": "stop alcohol consumption, consult doctor, medication, follow up"
    },
    "32": {
        "": "32",
        "id": "32",
        "Disease": "Jaundice",
        "Description": "Yellow staining of the skin and sclerae (the whites of the eyes) by abnormally high blood levels of the bile pigment bilirubin. The yellowing extends to other tissues and body fluids. Jaundice was once called the \"morbus regius\" (the regal disease) in the belief that only the touch of a king could cure it",
        "Precaution": "drink plenty of water, consume milk thistle, eat fruits and high fiberous food, medication"
    },
    "33": {
        "": "33",
        "id": "33",
        "Disease": "Hepatitis E",
        "Description": "A rare form of liver inflammation caused by infection with the hepatitis E virus (HEV). It is transmitted via food or drink handled by an infected person or through infected water supplies in areas where fecal matter may get into the water. Hepatitis E does not cause chronic liver disease.",
        "Precaution": "stop alcohol consumption, rest, consult doctor, medication"
    },
    "34": {
        "": "34",
        "id": "34",
        "Disease": "Dengue",
        "Description": "an acute infectious disease caused by a flavivirus (species Dengue virus of the genus Flavivirus), transmitted by aedes mosquitoes, and characterized by headache, severe joint pain, and a rash. \u2014 called also breakbone fever, dengue fever.",
        "Precaution": "drink papaya leaf juice, avoid fatty spicy food, keep mosquitos away, keep hydrated"
    },
    "35": {
        "": "35",
        "id": "35",
        "Disease": "Hepatitis D",
        "Description": "Hepatitis D, also known as the hepatitis delta virus, is an infection that causes the liver to become inflamed. This swelling can impair liver function and cause long-term liver problems, including liver scarring and cancer. The condition is caused by the hepatitis D virus (HDV).",
        "Precaution": "consult doctor, medication, eat healthy, follow up"
    },
    "36": {
        "": "36",
        "id": "36",
        "Disease": "Heart attack",
        "Description": "The death of heart muscle due to the loss of blood supply. The loss of blood supply is usually caused by a complete blockage of a coronary artery, one of the arteries that supplies blood to the heart muscle.",
        "Precaution": "call ambulance, chew or swallow asprin, keep calm, "
    },
    "37": {
        "": "37",
        "id": "37",
        "Disease": "Pneumonia",
        "Description": "Pneumonia is an infection in one or both lungs. Bacteria, viruses, and fungi cause it. The infection causes inflammation in the air sacs in your lungs, which are called alveoli. The alveoli fill with fluid or pus, making it difficult to breathe.",
        "Precaution": "consult doctor, medication, rest, follow up"
    },
    "38": {
        "": "38",
        "id": "38",
        "Disease": "Arthritis",
        "Description": "Arthritis is the swelling and tenderness of one or more of your joints. The main symptoms of arthritis are joint pain and stiffness, which typically worsen with age. The most common types of arthritis are osteoarthritis and rheumatoid arthritis.",
        "Precaution": "exercise, use hot and cold therapy, try acupuncture, massage"
    },
    "39": {
        "": "39",
        "id": "39",
        "Disease": "Gastroenteritis",
        "Description": "Gastroenteritis is an inflammation of the digestive tract, particularly the stomach, and large and small intestines. Viral and bacterial gastroenteritis are intestinal infections associated with symptoms of diarrhea , abdominal cramps, nausea , and vomiting .",
        "Precaution": "stop eating solid food for while, try taking small sips of water, rest, ease back into eating"
    },
    "40": {
        "": "40",
        "id": "40",
        "Disease": "Tuberculosis",
        "Description": "Tuberculosis (TB) is an infectious disease usually caused by Mycobacterium tuberculosis (MTB) bacteria. Tuberculosis generally affects the lungs, but can also affect other parts of the body. Most infections show no symptoms, in which case it is known as latent tuberculosis.",
        "Precaution": "cover mouth, consult doctor, medication, rest"
    }
}

module.exports = combinations