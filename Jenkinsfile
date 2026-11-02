pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                echo '=== ЭТАП 1: Компиляция исходного кода ==='
                bat '"C:\\Program Files\\Intellij IDEA\\plugins\\maven\\lib\\maven3\\bin\\mvn.cmd" compile'
            }
        }

        stage('Test') {
            steps {
                echo '=== ЭТАП 2: Запуск Unit-тестов ==='
                bat '"C:\\Program Files\\Intellij IDEA\\plugins\\maven\\lib\\maven3\\bin\\mvn.cmd" test'
            }
        }

        stage('Package') {
            steps {
                echo '=== ЭТАП 3: Упаковка приложения в JAR-архив ==='
                bat '"C:\\Program Files\\Intellij IDEA\\plugins\\maven\\lib\\maven3\\bin\\mvn.cmd" package -DskipTests'
            }
        }

        stage('Custom Maven Command (Dependency Tree)') {
            steps {
                echo '=== ЭТАП 4 (Индивидуальное задание): Вывод дерева зависимостей ==='
                bat '"C:\\Program Files\\Intellij IDEA\\plugins\\maven\\lib\\maven3\\bin\\mvn.cmd" dependency:tree'
            }
        }
    }

    post {
        always {
            echo '=== Сборка завершена ==='
        }
        success {
            echo 'Конвейер выполнен успешно! Все этапы пройдены.'
        }
        failure {
            echo 'Ошибка при выполнении конвейера! Проверьте логи.'
        }
    }
}