package base;

public class ConsoleStrings {
    // ошибки [error]
    public static final String RECORD_IS_NOT_DELETE = ConsoleColors.RED + "[FAIL] Запись не удалена" + ConsoleColors.RESET;
    public static final String ERROR_INDEX_SERVICE = ConsoleColors.RED + "[FAIL] Несуществующий индекс" + ConsoleColors.RESET;

    // ошибка записи [error of rec]
    public static final String TIME_IS_BUSY = "[FAIL] Время для данной услуги занято";
    public static final String ERROR_TIME = "[FAIL] Невозможно записаться, не хватает времени работы мастера";
    public static final String ERROR_SERVICE = "[FAIL] Данной услуги не существует";

    // успешные выводы [success out]
    public static final String CONNECT_SUCCESS = ConsoleColors.GREEN + "Подключение прошло, Ваш ID = " + ConsoleColors.RESET;
    public static final String OK = "ок";
    public static final String MAKE_RECORD_SUCCESS = ConsoleColors.GREEN + "Всё успешно. ID Вашей записи: " + ConsoleColors.RESET;
    public static final String DELETE_RECORD_SUCCESS = ConsoleColors.GREEN + "Запись успешно удалена!" + ConsoleColors.RESET;
    public static final String GET_ID_NEW_SERVICE = ConsoleColors.GREEN + "ID добавленной услуги : " + ConsoleColors.RESET;
    public static final String DELETE_SERVICE_SUCCESS = ConsoleColors.GREEN + "Услуга удалена" + ConsoleColors.RESET;

    // роль [role]
    public static final String WHO_ARE_YOU = ConsoleColors.CYAN + "-----КТО ТЫ???-----\n" + ConsoleColors.RESET;
    public static final String SET_EMPLOYEE = ConsoleColors.YELLOW + "<Сотрудник> " + ConsoleColors.RESET + "ВВЕДИ [С]";
    public static final String SET_CLIENT = ConsoleColors.YELLOW + "  <Клиент>  " + ConsoleColors.RESET + "ВВЕДИ [К]";
    public static final String EMPLOYEE = "К";
    public static final String CLIENT = "С";
    public static final String EMPLOYEE_BIG = ConsoleColors.YELLOW + "<<<<< СОТРУДНИК >>>>>\n" + ConsoleColors.RESET;
    public static final String CLIENT_BIG = ConsoleColors.YELLOW + "<<<<< КЛИЕНТ >>>>>\n" + ConsoleColors.RESET;

    // меню [menu]
    public static final String CHOOSE_MOVE = ConsoleColors.PURPLE + "\n<< Выбери действие >>" + ConsoleColors.RESET;
    public static final String ADD_SERVICE = ConsoleColors.BLUE + "[1] Добавить услугу" + ConsoleColors.RESET;
    public static final String DELETE_SERVICE_BY_ID = ConsoleColors.BLUE + "[2] Удалить услугу по ID" + ConsoleColors.RESET;
    public static final String GET_ALL_SERVICE = ConsoleColors.BLUE + "[3] Все услуги" + ConsoleColors.RESET;
    public static final String MAKE_RECORD = ConsoleColors.BLUE + "[1] Записаться" + ConsoleColors.RESET;
    public static final String DELETE_RECORD = ConsoleColors.BLUE + "[2] Отказаться от записи" + ConsoleColors.RESET;
    public static final String GET_TIME_MASTER = ConsoleColors.BLUE + "[4] Время мастера" + ConsoleColors.RESET;

    // поля ввода [input]
    public static final String INPUT_NAME_SERVICE = ConsoleColors.CYAN + "Введите [название] услуги " + ConsoleColors.RESET;
    public static final String INPUT_DURATION_SERVICE = ConsoleColors.CYAN + "Введите [длительность] услуги " + ConsoleColors.RESET;
    public static final String INPUT_PRICE_SERVICE = ConsoleColors.CYAN + "Введите [цену] услуги " + ConsoleColors.RESET;
    public static final String INPUT_ID_SERVICE = ConsoleColors.CYAN + "Введите [ID] для удаления услуги" + ConsoleColors.RESET;
    public static final String INPUT_TIME = ConsoleColors.CYAN + "Введите желаемое [время] (--:00 : [10:18])" + ConsoleColors.RESET;
    public static final String CHOOSE_ID_SERVICE = ConsoleColors.CYAN + "Выберите [ID] услуги" + ConsoleColors.RESET;
    public static final String CHOOSE_ID_RECORD = ConsoleColors.CYAN + "Выберите [ID] для удаления" + ConsoleColors.RESET;
    public static final String CHOOSE_CALENDAR_DAY = ConsoleColors.CYAN + "Выберите [день]" + ConsoleColors.RESET;

    // разделители [separator]
    public static final String SEPARATOR = "-------------------------------------------------------";
    public static final String SEPARATOR_RED = ConsoleColors.RED + SEPARATOR + ConsoleColors.RESET;
    public static final String SEPARATOR_YELLOW = ConsoleColors.YELLOW + SEPARATOR + ConsoleColors.RESET;
}
