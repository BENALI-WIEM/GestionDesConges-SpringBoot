package com.rhc.entity;

import com.rhc.service.CongeService;
import com.rhc.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;
@Component

public class CongesReminder {
    @Autowired
    private CongeService congeService;

    @Autowired
    private EmailService emailService;

    @Scheduled(cron = "0 0 9 * * ?") // Cette tâche s'exécute tous les jours à 9h00
    public void sendCongesReminders() {
        List<Conge> upcomingConges = congeService.getUpcomingConges();
        for (Conge conge : upcomingConges) {
            emailService.sendSimpleMessage(conge.getUtilisateur().getEmail(),
                    "Rappel de congé",
                    "Votre congé commence bientôt : " + conge.getDateDebut());
        }
    }

}
