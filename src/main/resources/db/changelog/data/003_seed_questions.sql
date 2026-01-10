-- liquibase formatted sql

-- changeset noufal:seed-questions-agegroup-0-3-003

INSERT INTO questions (
    id,
    question_en,
    question_mal,
    severity,
    category_id,
    agegroup_id,
    description,
    image
)
SELECT
    gen_random_uuid(),
    q.question_en,
    q.question_mal,
    q.severity,
    c.id,
    ag.id,
    q.description,
    NULL
FROM (
    VALUES
    -- Cognitive Development
    ('Does the child respond to familiar sounds?',
     'പരിചിതമായ ശബ്ദങ്ങൾക്ക് കുട്ടി പ്രതികരിക്കുന്നുണ്ടോ?',
     1, 'Cognitive Development',
     'Assesses auditory recognition and early cognitive responsiveness'),

    ('Does the child show curiosity toward new objects?',
     'പുതിയ വസ്തുക്കളോട് കുട്ടിക്ക് കൗതുകം കാണിക്കുന്നുണ്ടോ?',
     1, 'Cognitive Development',
     'Evaluates curiosity and exploratory behavior'),

    ('Does the child recognize familiar faces?',
     'പരിചിതമായ മുഖങ്ങളെ കുട്ടി തിരിച്ചറിയുന്നുണ്ടോ?',
     2, 'Cognitive Development',
     'Measures memory formation and visual recognition'),

    ('Does the child attempt to solve simple problems?',
     'ലളിതമായ പ്രശ്നങ്ങൾ പരിഹരിക്കാൻ കുട്ടി ശ്രമിക്കുന്നുണ്ടോ?',
     2, 'Cognitive Development',
     'Checks early problem-solving ability'),

    ('Does the child remember daily routines?',
     'ദൈനംദിന പ്രവർത്തനങ്ങൾ കുട്ടിക്ക് ഓർമ്മയുണ്ടോ?',
     3, 'Cognitive Development',
     'Evaluates routine memory and consistency'),

    -- Physical Development
    ('Can the child crawl or walk with support?',
     'പിന്തുണയോടെ കുട്ടിക്ക് ഇഴയാനോ നടക്കാനോ കഴിയുമോ?',
     1, 'Physical Development',
     'Assesses early gross motor development'),

    ('Does the child grasp objects using fingers?',
     'വിരലുകൾ ഉപയോഗിച്ച് വസ്തുക്കൾ പിടിക്കാൻ കുട്ടിക്ക് കഴിയുന്നുണ്ടോ?',
     1, 'Physical Development',
     'Evaluates fine motor control'),

    ('Can the child sit without support?',
     'പിന്തുണയില്ലാതെ കുട്ടിക്ക് ഇരിക്കാൻ കഴിയുമോ?',
     2, 'Physical Development',
     'Checks balance and trunk strength'),

    ('Does the child show coordinated movements?',
     'കുട്ടിയുടെ ചലനങ്ങൾ ഏകോപിതമാണോ?',
     2, 'Physical Development',
     'Measures motor coordination'),

    ('Can the child pick up small objects?',
     'ചെറിയ വസ്തുക്കൾ എടുത്തെടുക്കാൻ കുട്ടിക്ക് കഴിയുമോ?',
     3, 'Physical Development',
     'Evaluates hand-eye coordination'),

    -- Language & Communication
    ('Does the child respond to their name?',
     'സ്വന്തം പേരിന് കുട്ടി പ്രതികരിക്കുന്നുണ്ടോ?',
     1, 'Language & Communication',
     'Assesses auditory attention and name recognition'),

    ('Does the child make babbling sounds?',
     'കുട്ടി ബാബ്ലിംഗ് ശബ്ദങ്ങൾ ഉണ്ടാക്കുന്നുണ്ടോ?',
     1, 'Language & Communication',
     'Evaluates early vocal expression'),

    ('Does the child attempt to imitate sounds?',
     'ശബ്ദങ്ങൾ അനുകരിക്കാൻ കുട്ടി ശ്രമിക്കുന്നുണ്ടോ?',
     2, 'Language & Communication',
     'Checks sound imitation skills'),

    ('Does the child use simple words?',
     'കുട്ടി ലളിതമായ വാക്കുകൾ ഉപയോഗിക്കുന്നുണ്ടോ?',
     2, 'Language & Communication',
     'Measures early vocabulary development'),

    ('Does the child understand simple instructions?',
     'ലളിതമായ നിർദ്ദേശങ്ങൾ കുട്ടിക്ക് മനസ്സിലാകുന്നുണ്ടോ?',
     3, 'Language & Communication',
     'Evaluates receptive language ability'),

    -- Social & Emotional Development
    ('Does the child smile at familiar people?',
     'പരിചിതരായ ആളുകളെ കണ്ടാൽ കുട്ടി പുഞ്ചിരിക്കുന്നുണ്ടോ?',
     1, 'Social & Emotional Development',
     'Assesses social recognition and bonding'),

    ('Does the child express emotions clearly?',
     'കുട്ടി വികാരങ്ങൾ വ്യക്തമായി പ്രകടിപ്പിക്കുന്നുണ്ടോ?',
     1, 'Social & Emotional Development',
     'Evaluates emotional expression'),

    ('Does the child show attachment to caregivers?',
     'പരിപാലകരോട് കുട്ടിക്ക് അടുപ്പം കാണിക്കുന്നുണ്ടോ?',
     2, 'Social & Emotional Development',
     'Measures emotional attachment'),

    ('Does the child respond to social cues?',
     'സാമൂഹിക സൂചനകൾക്ക് കുട്ടി പ്രതികരിക്കുന്നുണ്ടോ?',
     2, 'Social & Emotional Development',
     'Checks social responsiveness'),

    ('Does the child seek comfort when distressed?',
     'അസ്വസ്ഥതയുള്ളപ്പോൾ കുട്ടി ആശ്വാസം തേടുന്നുണ്ടോ?',
     3, 'Social & Emotional Development',
     'Evaluates emotional regulation'),

    -- Adaptive & Self-Care Skills
    ('Can the child hold a bottle or cup?',
     'കുപ്പിയെയോ കപ്പിനെയോ പിടിക്കാൻ കുട്ടിക്ക് കഴിയുമോ?',
     1, 'Adaptive & Self-Care Skills',
     'Assesses basic self-feeding readiness'),

    ('Does the child attempt to feed themselves?',
     'സ്വയം ഭക്ഷണം കഴിക്കാൻ കുട്ടി ശ്രമിക്കുന്നുണ്ടോ?',
     1, 'Adaptive & Self-Care Skills',
     'Evaluates early independence'),

    ('Does the child cooperate during dressing?',
     'വസ്ത്രധാരണ സമയത്ത് കുട്ടി സഹകരിക്കുന്നുണ്ടോ?',
     2, 'Adaptive & Self-Care Skills',
     'Checks adaptive cooperation'),

    ('Does the child adapt to daily routines?',
     'ദൈനംദിന ക്രമങ്ങളോട് കുട്ടി പൊരുത്തപ്പെടുന്നുണ്ടോ?',
     2, 'Adaptive & Self-Care Skills',
     'Measures routine adaptability'),

    ('Does the child attempt basic self-care actions?',
     'അടിസ്ഥാന സ്വയംപരിപാലന പ്രവർത്തനങ്ങൾ കുട്ടി ശ്രമിക്കുന്നുണ്ടോ?',
     3, 'Adaptive & Self-Care Skills',
     'Evaluates early self-care capability')

) AS q(question_en, question_mal, severity, category_name, description)
JOIN category c ON c.name = q.category_name
JOIN age_group ag ON ag.start_age = 0 AND ag.end_age = 3;
