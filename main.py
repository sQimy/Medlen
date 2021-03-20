x = -1
while x != 0:
    print(
        "1: #Номер появления слова\n2: #Словарь синонимов \n3:------ \n4: #Самое частое слово \n5:-----\n6: #Страны и города\n0:Выход")
    x = int(input("Введите номер задания "))
    if x == 1:
        count = {}
        for a in input().split():
            count[a] = count.get(a, 0) + 1
            print(count[a], end=' ')
            print("\n")

    elif x == 2:
        count = int(input())  # колво строк
        slov = {}  # Словарь
        for i in range(count):
            word1, word2 = input().split()  # записываем 2 слова
            slov[word1], slov[word2] = word2, word1  # связываем по ключу слова

        print(slov[input()])  # выводим сининим по ключу

    elif x == 3:

        print("Не осилил")
    elif x == 4:
        count = {}
        for i in range(int(input())):
            a = input().split()
            for word in a:
                count[word] = count.get(word, 0) + 1
        max_count = max(count.values())
        max_often = [k for k, v in count.items() if v == max_count]
        print("Самое частое слово ", min(max_often))
    elif x == 5:
        print("НЕ осилил блин")

    elif x == 6:
        home_country = {}
        for i in range(int(input())): #число строк городов стран
            country, *cities = input().split() #привязка по ключу города с страной
            for city in cities:
                home_country[city] = country

        for i in range(int(input())): #число строк городов
            print(home_country[input()],"\n")


    elif x == 0:
        print("Пока")
    else:

        print("Такого задания нет")
