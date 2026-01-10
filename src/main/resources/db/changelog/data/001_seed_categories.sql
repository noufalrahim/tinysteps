-- liquibase formatted sql

-- changeset noufal:seed-categories-001
CREATE EXTENSION IF NOT EXISTS "pgcrypto";

INSERT INTO category (id, name, description, image, weight) VALUES
(gen_random_uuid(), 'Cognitive Development',
 'Development of thinking and reasoning abilities, including problem-solving, attention span, memory formation, object permanence, curiosity, and early learning patterns',
 'https://i.ibb.co/tMwWZxPd/Gemini-Generated-Image-sb4lkzsb4lkzsb4l.png', 90),

(gen_random_uuid(), 'Physical Development',
 'Gross and fine motor skills, balance, coordination, strength, and overall physical growth milestones',
 'https://i.ibb.co/tMwWZxPd/Gemini-Generated-Image-sb4lkzsb4lkzsb4l.png', 85),

(gen_random_uuid(), 'Language & Communication',
 'Understanding and use of language, speech clarity, vocabulary growth, listening skills, and early expressive communication',
 'https://i.ibb.co/tMwWZxPd/Gemini-Generated-Image-sb4lkzsb4lkzsb4l.png', 90),

(gen_random_uuid(), 'Social & Emotional Development',
 'Emotional regulation, social interaction, empathy, attachment, confidence, and ability to form relationships',
 'https://i.ibb.co/tMwWZxPd/Gemini-Generated-Image-sb4lkzsb4lkzsb4l.png', 95),

(gen_random_uuid(), 'Adaptive & Self-Care Skills',
 'Independence in daily activities such as feeding, dressing, hygiene, adaptability to routines, and problem handling in real-life situations',
 'https://i.ibb.co/tMwWZxPd/Gemini-Generated-Image-sb4lkzsb4lkzsb4l.png', 80);
