package com.ivanov_sergey.cryptoanalyser.text_processing;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class TextProcessing {

    private static final char[] SYMBOLS = {'\n', ' ', '!', '"', '\'', ',', '-', '.', ':', '?'};

    private static final String[] FREQUENTLY_RUSSIAN_STRINGS = {"и", "не", "на", "быть", "он",
            "что", "это", "она", "этот", "но", "они", "мы", "как", "из", "который", "то", "за", "свой", "что",
            "весь", "год", "от", "так", "для", "ты", "же", "все", "тот", "мочь", "вы", "человек", "такой", "его",
            "сказать", "только", "или", "ещё", "бы", "себя", "один", "как", "уже", "до", "время", "если", "сам",
            "когда", "другой", "вот", "говорить", "наш", "мой", "знать", "стать", "при", "чтобы", "дело", "жизнь",
            "кто", "первый", "очень", "два", "день", "её", "новый", "рука", "даже", "во", "со", "раз", "где", "там",
            "под", "можно", "ну", "какой", "после", "их", "работа", "без", "самый", "потом", "надо", "хотеть", "ли",
            "слово", "идти", "большой", "должен", "место", "иметь", "ничто", "то", "сейчас", "тут", "лицо", "каждый",
            "друг", "нет", "теперь", "ни", "глаз", "тоже", "тогда", "видеть", "вопрос", "через", "да", "здесь", "дом",
            "да", "потому", "сторона", "какой-то", "думать", "сделать", "страна", "жить", "чем", "мир", "об",
            "последний", "случай", "голова", "более", "делать", "что-то", "смотреть", "ребенок", "просто", "конечно",
            "сила", "российский", "конец", "перед", "несколько", "вид", "система", "всегда", "работать", "между",
            "три", "нет", "понять", "пойти", "часть", "спросить", "город", "дать", "также", "никто", "понимать",
            "получить", "отношение", "лишь", "второй", "именно", "ваш", "хотя", "ни", "сидеть", "над", "женщина",
            "оказаться", "русский", "один", "взять", "прийти", "являться", "деньги", "почему", "вдруг", "любить",
            "стоить", "почти", "земля", "общий", "ведь", "машина", "однако", "сразу", "хорошо", "вода", "отец",
            "высокий", "остаться", "выйти", "много", "проблема", "начать", "хороший", "час", "это", "сегодня",
            "право", "совсем", "нога", "считать", "главный", "решение", "увидеть", "дверь", "казаться", "образ",
            "писать", "история", "лучший", "власть", "закон", "все", "война", "бог", "голос", "найти", "поэтому",
            "стоять", "вообще", "тысяча", "больше", "вместе", "маленький", "книга", "некоторый", "решить", "любой",
            "возможность", "результат", "ночь", "стол", "никогда", "имя", "область", "молодой", "пройти", "например",
            "статья", "оно", "число", "компания", "про", "государственный", "полный", "принять", "народ", "никакой",
            "советский", "жена", "настоящий", "всякий", "группа", "развитие", "процесс", "суд", "давать", "ответить",
            "старый", "условие", "твой", "пока", "средство", "помнить", "начало", "ждать", "свет", "пора", "путь",
            "душа", "куда", "нужно", "разный", "нужный", "уровень", "иной", "форма", "связь", "уж", "минута", "кроме",
            "находиться", "опять", "многий", "белый", "собственный", "улица", "черный", "написать", "вечер", "снова",
            "основной", "качество", "мысль", "дорога", "мать", "действие", "месяц", "оставаться", "государство",
            "язык", "любовь", "взгляд", "мама", "играть", "далекий", "лежать", "нельзя", "век", "школа", "подумать",
            "уйти", "цель", "среди", "общество", "посмотреть", "деятельность", "организация", "кто-то", "вернуться",
            "президент", "комната", "порядок", "момент", "театр", "следовать", "читать", "письмо", "подобный",
            "следующий", "утро", "особенно", "помощь", "ситуация", "роль", "бывать", "ходить", "рубль", "начинать",
            "появиться", "смысл", "состояние", "называть", "рядом", "квартира", "назад", "равный", "из-за", "орган",
            "внимание", "тело", "труд", "прийтись", "хотеться", "сын", "мера", "пять", "смерть", "живой", "рынок",
            "программа", "задача", "предприятие", "известный", "окно", "вести", "совершенно", "военный", "разговор",
            "показать", "правительство", "важный", "семья", "великий", "производство", "простой", "значит", "третий",
            "сколько", "огромный", "давно", "политический", "информация", "действительно", "положение", "поставить",
            "бояться", "наконец", "центр", "происходить", "ответ", "муж", "автор", "все-таки", "стена", "существовать",
            "даже", "интерес", "становиться", "федерация", "правило", "оба", "часто", "московский", "управление",
            "слышать", "быстро", "смочь", "заметить", "как-то", "мужчина", "долго", "правда", "идея", "партия",
            "иногда", "использовать", "пытаться", "готовый", "чуть", "зачем", "представить", "чувствовать", "создать",
            "совет", "счет", "сердце", "движение", "вещь", "материал", "неделя", "чувство", "затем", "данный",
            "заниматься", "продолжать", "красный", "глава", "ко", "слушать", "наука", "узнать", "ряд", "газета",
            "причина", "против", "плечо", "современный", "цена", "план", "приехать", "речь", "четыре", "отвечать",
            "точка", "основа", "товарищ", "культура", "слишком", "рассказывать", "вполне", "далее", "рассказать",
            "данные", "представлять", "мнение", "социальный", "около", "документ", "институт", "ход", "брать",
            "забыть", "проект", "ранний", "встреча", "особый", "целый", "директор", "провести", "спать", "плохой",
            "может", "впрочем", "сильный", "наверное", "скорый", "ведь", "срок", "палец", "опыт", "помочь", "больше",
            "приходить", "служба", "крупный", "внутренний", "просить", "вспомнить", "открыть", "привести", "судьба",
            "пока", "девушка", "поскольку", "очередь", "лес", "пусть", "экономический", "оставить", "правый",
            "состав", "словно", "федеральный", "спрашивать", "принимать", "член", "искать", "близкий", "количество",
            "похожий", "событие", "объект", "зал", "создание", "войти", "различный", "значение", "назвать",
            "достаточно", "период", "хоть", "шаг", "необходимый", "успеть", "произойти", "брат", "искусство",
            "единственный", "легкий", "структура", "выходить", "номер", "предложить", "пример", "пить",
            "исследование", "гражданин", "глядеть", "человеческий", "игра", "начальник", "сей", "рост",
            "ехать", "международный", "тема", "принцип", "дорогой", "попасть", "десять", "начаться", "верить",
            "метод", "тип", "фильм", "небольшой", "держать", "либо", "позволять", "край", "местный", "менее",
            "гость", "купить", "уходить", "собираться", "воздух", "туда", "относиться", "бывший", "требовать",
            "характер", "борьба", "использование", "кстати", "подойти", "размер", "удаться", "образование",
            "получать", "мальчик", "кровь", "район", "небо", "американский", "армия", "класс", "представитель",
            "участие", "девочка", "политика", "сначала", "герой", "картина", "широкий", "доллар", "спина",
            "территория", "мировой", "пол", "тяжелый", "довольно", "поле", "изменение", "умереть", "более",
            "направление", "рисунок", "течение", "возможный", "церковь", "банк", "отдельный", "средний", "красивый",
            "сцена", "население", "большинство", "сесть", "двадцать", "случиться", "музыка", "короткий", "правда",
            "проходить", "составлять", "свобода", "память", "приходиться", "причем", "команда", "установить", "союз",
            "будто", "поднять", "врач", "серьезный", "договор", "стараться", "уметь", "встать", "дерево", "интересный",
            "факт", "добрый", "всего", "хозяин", "национальный", "однажды", "длинный", "природа", "домой", "страшный",
            "прошлый", "будто", "общественный", "угол", "чтоб", "телефон", "позиция", "проводить", "скоро", "наиболее",
            "двор", "обычно", "бросить", "разве", "писатель", "самолет", "объем", "далеко", "род", "солнце", "вера",
            "берег", "спектакль", "фирма", "способ", "завод", "цвет", "трудно", "журнал", "руководитель", "специалист",
            "возможно", "детский", "точно", "объяснить", "оценка", "единый", "снять", "определенный", "низкий",
            "нравиться", "услышать", "регион", "связать", "песня", "процент", "родитель", "позволить", "чужой",
            "море", "странный", "требование", "чистый", "весьма", "какой-нибудь", "основание", "половина", "поехать",
            "положить", "входить", "легко", "поздний", "роман", "круг", "анализ", "стихи", "автомобиль", "специальный",
            "экономика", "литература", "бумага", "вместо", "впервые", "видно", "научный", "оказываться", "поэт",
            "показывать", "степень", "вызвать", "касаться", "господин", "надежда", "сложный", "вокруг", "предмет",
            "отметить", "заявить", "вариант", "министр", "откуда", "реальный", "граница", "действовать", "дух",
            "модель", "операция", "пара", "сон", "немного", "название", "ум", "повод", "старик", "способный", "мало",
            "миллион", "малый", "старший", "успех", "практически", "получиться", "личный", "счастье", "необходимо",
            "свободный", "ребята", "обычный", "кабинет", "прекрасный", "высший", "кричать", "прежде", "магазин",
            "пространство", "выход", "остановиться", "удар", "база", "знание", "текст", "сюда", "темный", "защита",
            "предлагать", "руководство", "вовсе", "площадь", "сознание", "гражданский", "убить", "возраст", "молчать",
            "согласиться", "участник", "участок", "рано", "пункт", "несмотря", "сильно", "столь", "сообщить", "линия",
            "бежать", "желание", "папа", "кажется", "петь", "доктор", "губа", "известно", "дома", "вызывать", "дочь",
            "показаться", "среда", "председатель", "представление", "солдат", "художник", "принести", "волос",
            "оружие", "выглядеть", "соответствие", "никак", "ветер", "внешний", "парень", "служить", "зрение",
            "попросить", "генерал", "состоять", "огонь", "отдать", "боевой", "понятие", "строительство", "ухо",
            "выступать", "грудь", "нос", "ставить", "завтра", "возникать", "когда", "страх", "услуга", "рабочий",
            "что-нибудь", "глубокий", "содержание", "радость", "безопасность", "надеяться", "продукт", "видимо",
            "комплекс", "бизнес", "подняться", "вспоминать", "мало", "сад", "долгий", "одновременно", "называться",
            "сотрудник", "лето", "тихо", "зато", "прямой", "курс", "помогать", "предложение", "финансовый",
            "открытый", "почему-то", "значить", "возникнуть", "рот", "где-то", "технология", "знакомый", "недавно",
            "реформа", "отсутствие", "нынешний", "собака", "камень", "будущее", "звать", "рассказ", "контроль",
            "позвонить", "река", "хватать", "продукция", "сумма", "техника", "исторический", "вновь", "народный",
            "прямо", "ибо", "выпить", "здание", "сфера", "знаменитый", "иначе", "потерять", "необходимость", "больший",
            "фонд", "иметься", "вперед", "подготовка", "вчера", "лист", "пустой", "очередной", "республика",
            "хозяйство", "полностью", "получаться", "учиться", "плохо", "воля", "судебный", "бюджет", "возвращаться",
            "расти", "снег", "деревня", "обнаружить", "мужик", "постоянно", "зеленый", "элемент", "обстоятельство",
            "почувствовать", "немец", "многое", "победа", "источник", "немецкий", "золотой", "передать", "технический",
            "нормальный", "едва", "желать", "ожидать", "некий", "звезда", "городской", "выбор", "соответствующий",
            "масса", "составить", "итог", "сестра", "что", "шесть", "ясно", "практика", "сто", "нести", "определить",
            "проведение", "карман", "любимый", "родной", "западный", "обязательно", "слава", "кухня", "определение",
            "пользоваться", "быстрый"};

    private static final String[] FREQUENTLY_ENGLISH_STRINGS = {"the", "of", "and",
            "in", "to", "have", "it", "for", "that", "you", "with", "not", "this",
            "but", "from", "they", "his", "she", "which", "as", "we", "say", "will", "would", "can", "if",
            "their", "go", "what", "there", "all", "get", "her", "make", "who", "out", "up", "see", "know", "time",
            "take", "them", "some - несколько, какой", "could", "so", "him", "year", "into", "its", "then", "think",
            "my", "come", "than", "more", "about", "now", "last", "your", "me", "no", "other", "give", "just",
            "should", "these", "people", "also", "well", "any", "only", "new", "very", "when", "may", "way",
            "look", "like", "use", "such", "how", "because", "good", "find", "man", "our", "want", "day",
            "between", "even", "many", "those", "after", "down", "yeah", "thing", "tell - сказать (кому",
            "through", "back", "still", "must", "child", "here", "over - над, выше (предлог); пере", "too", "put",
            "own", "work", "become", "old", "government", "mean", "part", "leave", "life", "great", "where", "case",
            "woman", "seem", "same", "us", "need", "feel", "each", "might", "much", "ask", "group", "number", "yes",
            "however", "another", "again", "world", "area", "show", "course", "shall", "under", "problem", "against",
            "never", "most", "service", "try", "call", "hand", "party", "high", "something - что", "school", "small",
            "place", "before", "why", "while", "away", "keep", "point", "house", "different", "country", "really",
            "provide", "week", "hold", "large", "member", "off", "always", "next", "follow", "without", "turn", "end",
            "local", "during", "bring", "word", "begin", "although", "example", "family", "rather", "fact", "social",
            "write", "state", "percent", "quite", "both", "start", "run", "long", "right", "set", "help", "every",
            "home", "month", "side", "night", "important", "eye", "head", "question", "play", "power", "money",
            "change", "move", "interest", "order", "book", "often", "young", "national", "pay", "hear", "room",
            "whether", "water", "form", "car", "others", "yet", "perhaps", "meet", "till", "though", "policy",
            "include", "believe", "already", "possible", "nothing", "line", "allow", "effect", "big", "late",
            "lead", "stand", "idea", "study", "lot", "live", "job", "since", "name", "result", "body", "happen",
            "friend", "least", "almost", "carry", "authority", "early", "view", "himself", "public", "usually",
            "together", "talk", "report", "face", "sit", "appear", "continue", "able", "political", "hour", "rate",
            "law", "door", "company", "court", "fuck", "little", "because of - из", "office", "let", "war", "reason",
            "less", "subject", "person", "term", "full", "sort", "require", "suggest", "far", "towards", "anything",
            "period", "read", "society", "process", "mother", "offer", "voice", "once", "police", "lose", "add",
            "probably", "expect", "ever - коогда", "price", "action", "issue", "remember", "position", "low",
            "matter", "community", "remain", "figure", "type", "actually - вообще", "education", "fall", "speak",
            "few", "today", "enough", "open", "bad", "buy", "minute", "moment", "girl", "age", "centre", "stop",
            "control", "send", "health", "decide", "main", "win", "wound", "understand", "develop", "class",
            "industry", "receive", "several", "return", "build", "spend", "force", "condition", "itself", "paper",
            "themselves", "major", "describe", "agree", "economic", "upon", "learn", "general", "century", "therefore",
            "father", "section", "patient", "around", "activity", "road", "table", "cow", "including", "church",
            "reach", "real", "lie", "mind", "likely", "among", "team", "death", "soon", "act", "sense", "staff",
            "certain", "student", "half", "language", "walk", "die", "special", "difficult", "international",
            "department", "management", "morning", "draw", "hope", "across", "plan", "product", "city", "committee",
            "ground", "letter", "create", "evidence", "foot", "clear", "boy", "game", "food", "role", "practice",
            "bank", "else", "support", "sell", "event", "building", "behind", "sure", "pass", "black", "stage",
            "meeting", "hi", "sometimes", "thus", "accept", "available", "town", "art", "further", "club", "arm",
            "history", "parent", "land", "trade", "watch", "white", "situation", "whose", "ago", "teacher", "record",
            "manager", "relation", "common", "system", "strong", "whole", "field", "free", "break", "yesterday",
            "window", "account", "explain", "stay", "wait", "material", "air", "wife", "cover", "apply", "love",
            "project", "raise", "sale", "relationship", "indeed", "please", "light", "claim", "base", "care",
            "someone", "everything", "certainly", "rule", "cut", "grow", "similar", "story", "quality", "tax",
            "worker", "nature", "structure", "necessary", "pound", "method", "unit", "central", "bed", "union",
            "movement", "board", "true", "especially", "short", "personal", "detail", "model", "bear", "single",
            "join", "reduce", "establish", "herself", "wall", "easy", "private", "computer", "former", "hospital",
            "chapter", "scheme", "bye", "consider", "council", "development", "experience", "information", "involve",
            "theory", "within", "choose", "wish", "property", "achieve", "financial", "poor", "blow", "charge",
            "director", "drive", "approach", "chance", "application", "seek", "cool", "foreign", "along", "top",
            "amount", "son", "operation", "fail", "human", "opportunity", "simple", "leader", "level", "production",
            "value", "firm", "picture", "source", "security", "serve", "according", "business", "decision", "contract",
            "wide", "agreement", "kill", "site", "either", "various", "screw", "test", "eat", "close", "represent",
            "colour", "shop", "benefit", "animal", "heart", "election", "purpose", "due", "secretary", "rise", "date",
            "hard", "music", "hair", "prepare", "anyone - кто", "pattern", "manage", "piece", "discuss", "prove",
            "front", "evening", "royal", "tree", "population", "fine", "plant", "pressure", "response", "catch",
            "street", "knowledge", "despite", "design", "kind", "page", "enjoy", "individual", "rest", "instead",
            "wear", "basis", "size", "fire", "series", "success", "natural", "wrong", "near", "round", "thought",
            "list", "argue", "final", "future", "introduce", "enter", "space", "arrive", "ensure", "statement",
            "balcony", "attention", "principle", "pull", "doctor", "choice", "refer", "feature", "couple", "step",
            "following", "thank", "machine", "income", "training", "present", "association", "film", "difference",
            "fucking", "region", "effort", "player", "everyone", "village", "organisation", "whatever", "news",
            "nice", "modern", "cell", "current", "legal", "energy", "finally", "degree", "mile", "means", "whom",
            "treatment", "sound", "above", "task", "red", "happy", "behaviour", "identify", "resource", "defence",
            "garden", "floor", "technology", "style", "feeling", "science", "relate", "doubt", "ok", "produce",
            "horse", "answer", "compare", "suffer", "forward", "announce", "user", "character", "risk", "normal",
            "myself", "dog", "obtain", "quickly", "army", "forget", "ill", "station", "glass", "cup", "previous",
            "husband", "recently", "publish", "serious", "anyway", "visit", "capital", "sock", "note", "season",
            "argument", "listen", "responsibility", "significant", "deal", "prime", "economy", "finish", "duty",
            "fight", "train", "maintain", "attempt", "leg", "save", "suddenly", "brother", "improve", "avoid",
            "teenager", "wonder", "fun", "title", "post", "hotel", "aspect", "increase", "surname", "industrial",
            "express", "summer", "determine", "generally", "daughter", "exist", "used to", "share", "baby", "nearly",
            "smile", "sorry", "sea", "skill", "treat", "remove", "concern", "university", "left", "dead", "discussion",
            "specific", "box", "outside", "total", "bit", "cost", "girlfriend", "market", "occur", "research",
            "wonderful", "division", "throw", "officer", "procedure", "fill", "king", "assume", "image", "oil",
            "obviously", "unless", "appropriate", "military", "proposal", "mention", "client", "sector", "direction",
            "admit", "basic", "instance", "sign", "original", "successful", "reflect", "aware", "pardon", "measure",
            "attitude", "yourself", "exactly", "commission", "beyond", "seat", "president", "encourage", "addition",
            "goal", "miss", "popular", "affair", "technique", "respect", "drop", "professional", "fly", "version",
            "maybe", "ability", "operate", "goods", "campaign", "heavy", "advice", "institution", "discover",
            "surface", "library", "pupil", "refuse", "prevent", "tasty", "dark", "teach", "memory",
            "culture", "blood", "majority", "insane", "variety", "depend", "bill", "competition", "ready", "access",
            "hit", "stone", "useful", "extent", "employment", "regard", "apart", "besides", "shit", "text",
            "parliament", "recent", "article", "object", "context", "notice", "complete", "direct", "immediately",
            "collection", "card", "interesting", "considerable", "television", "agency", "except", "physical",
            "check", "sun", "possibility", "species", "speaker", "second", "laugh", "weight", "responsible",
            "document", "solution", "medical", "hot", "budget", "river", "fit", "push", "tomorrow", "requirement",
            "cold", "opposition", "opinion", "drug", "quarter", "option", "worth", "define", "influence", "occasion",
            "software", "highly", "exchange", "lack", "concept", "blue", "star", "radio", "arrangement", "examine",
            "bird", "busy", "chair", "green", "band", "sex", "finger", "independent", "equipment", "north", "message",
            "afternoon", "fear", "drink", "fully", "race", "strategy", "extra", "scene", "slightly", "kitchen",
            "arise", "speech", "network", "tea", "peace", "failure", "employee", "ahead", "scale", "attend", "hardly",
            "shoulder", "otherwise - по", "railway", "supply", "owner", "associate", "corner", "past", "match",
            "sport", "beautiful", "hang", "marriage", "civil", "sentence", "crime", "ball", "marry", "wind", "truth",
            "protect"};

    private static final char[] CYRILLIC = new char[]{'а', 'б', 'в', 'г', 'д', 'е', 'ё', 'ж', 'з', 'и', 'й', 'к', 'л',
            'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ', 'ъ', 'ы', 'ь', 'э', 'ю', 'я'};

    private static final char[] LATIN = new char[]{'a', 'b', 'c', 'd', 'e',
            'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};

    // According to statistics, any letters are meeting most frequently.
    private static final char[] MOST_FREQUENT_RUSSIAN_LETTERS = new char[]{'о', 'е', 'а', 'и', 'т', 'н'};
    private static final char[] MOST_FREQUENT_ENGLISH_LETTERS = new char[]{'e', 't', 'a', 'o', 'i', 'n'};

    public static final String RUSSIAN_LANGUAGE = "Cyrillic";
    public static final String ENGLISH_LANGUAGE = "Latin";

    public static final String ALPHABET_OF_SYMBOLS = "Symbols";
    public static String language = ENGLISH_LANGUAGE;

    private TextProcessing() {
    }

    public static int getIndex(char letter, String language) {
        if (RUSSIAN_LANGUAGE.equals(language))
            for (int i = 0; i < CYRILLIC.length; i++) {
                if (letter == CYRILLIC[i]) {
                    return i;
                }
            }
        else if (ENGLISH_LANGUAGE.equals(language)) {
            int index = Arrays.binarySearch(LATIN, letter);
            if (index >= 0) {
                return index;
            } else {
                return -1;
            }
        }
        return -1;
    }

    public static boolean isSymbol(char symbol) {
        int index = Arrays.binarySearch(SYMBOLS, symbol);
        return index >= 0;
    }

    public static char[] choiceOfAlphabet(String language) {
        if (RUSSIAN_LANGUAGE.equals(language)) {
            return CYRILLIC;
        } else if (ENGLISH_LANGUAGE.equals(language)) {
            return LATIN;
        } else if (ALPHABET_OF_SYMBOLS.equals(language)) {
            return SYMBOLS;
        }
        return new char[0];
    }

    public static char[] getArrayGreatestFrequentLettersOfAlphabets(String language) {

        if (RUSSIAN_LANGUAGE.equals(language)) {
            return MOST_FREQUENT_RUSSIAN_LETTERS;
        } else if (ENGLISH_LANGUAGE.equals(language)) {
            return MOST_FREQUENT_ENGLISH_LETTERS;
        }
        return new char[0];
    }

    public static String[] getArrayFrequentWords(String language) {

        if (RUSSIAN_LANGUAGE.equals(language)) {
            return FREQUENTLY_RUSSIAN_STRINGS;
        } else if (ENGLISH_LANGUAGE.equals(language)) {
            return FREQUENTLY_ENGLISH_STRINGS;
        }
        return null;
    }

    public static char getMostFrequentLetterOfText(HttpServletRequest req) throws ServletException, IOException {

        Part filePart = req.getPart("file");
        try (InputStream inputStream = filePart.getInputStream();
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream))) {

            HashMap<Character, Integer> mapa = new HashMap<>();

            int value;
            while ((value = bufferedReader.read()) != -1) {

                char wantedChar = Character.toLowerCase((char) value);

                if (Character.isLetter(wantedChar)
                        && (TextProcessing.getIndex(wantedChar, TextProcessing.language) >= 0)) {

                    if (mapa.containsKey(wantedChar)) {
                        mapa.put(wantedChar, mapa.get(wantedChar) + 1);
                    } else {
                        mapa.put(wantedChar, 1);
                    }
                }
            }

            char maxRepetitions = 0;
            int max = 0;

            Set<Map.Entry<Character, Integer>> entries = mapa.entrySet();
            for (Map.Entry<Character, Integer> pair : entries) {
                char character = pair.getKey();
                int amount = pair.getValue();

                if (amount > max) {

                    maxRepetitions = character;
                    max = amount;
                }
            }
            return maxRepetitions;
        }
    }
}
